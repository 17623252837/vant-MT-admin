package com.hrh.mt.service.impl;

import com.hrh.mt.common.utils.*;
import com.hrh.mt.domain.MtUser;
import com.hrh.mt.mapper.MtUserMapper;
import com.hrh.mt.service.PhoneCodeService;
import com.hrh.mt.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {

    @Autowired
    private MtUserMapper mtUserMapper;

    @Autowired
    private BaseResult baseResult;

    @Autowired
    private RedisService redisService;
    MtUser user = new MtUser();

    @Override
    public BaseResult getCode(String phone) {
        String code1 = getCode();
        //对手机号码
        if(CheckPhone.isPhone(phone)){//验证通过
            user.setUserPhone(phone);
            MtUser mtUser = mtUserMapper.selectOne(user);
            if(mtUser != null){//账号存
                boolean code = GetPhoneCodeUtil.getCode(phone,code1);
                redisService.put(phone,code1,3000);
                baseResult = code ? BaseResult.success() : BaseResult.fail();
            }

            else{//账号不存在
                //注册
                user.setUnidUserId(UUID.randomUUID().toString());
                user.setUserCreated(new Date());
                int insert = mtUserMapper.insert(user);
                //注册成功发送验证码

                if(insert > 0){
                    //发送验证码
                    boolean code = GetPhoneCodeUtil.getCode(phone,code1);
                    redisService.put(phone,code1,3000);
                    baseResult = code ? BaseResult.success() : BaseResult.fail();
                }
                else {//注册失败
                    baseResult = BaseResult.fail("注册失败");
                }
            }
        }
        else{//验证失败
            baseResult = BaseResult.fail("手机号码格式错误");
        }

        return baseResult;
    }

    @Override
    public BaseResult putCode(String phone, String code) {
        String o = (String) redisService.get(phone);
        if(o != null){
            if(o.equals(code)){
                //验证成功
                baseResult = BaseResult.success();
            }
            else {
                //验证失败
                baseResult = BaseResult.fail();
            }
        }else {
            baseResult = BaseResult.fail();
        }
        return baseResult;
    }


    // 封装生成6位随机数的方法
    private static String getCode() {
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += (int) Math.floor(Math.random() * 10);
        }
        return code;
    }
}
