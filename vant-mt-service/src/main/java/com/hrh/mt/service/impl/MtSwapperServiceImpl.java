package com.hrh.mt.service.impl;

import com.hrh.mt.common.utils.BaseResult;
import com.hrh.mt.common.utils.OSSClientUtil;
import com.hrh.mt.domain.MtSwapper;
import com.hrh.mt.mapper.MtSwapperMapper;
import com.hrh.mt.service.MtSwapperService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MtSwapperServiceImpl implements MtSwapperService{

    @Resource
    private MtSwapperMapper mtSwapperMapper;

    MtSwapper mtSwapper = new MtSwapper();

    @Autowired
    private BaseResult baseResult;
    @Override
    public BaseResult getSwappers() {
        baseResult = BaseResult.fail("数据数据未录入");
        List<MtSwapper> list = new ArrayList<>();
        mtSwapper.setSwapperState(0);
        //阿里云oss云存储6小时更换一次地址
        List<MtSwapper> select = mtSwapperMapper.select(mtSwapper);
        //获取
        for (MtSwapper swapper : select) {
            String swapperName = swapper.getSwapperName();
            if(StringUtils.isNotBlank(swapperName)){
                String url = OSSClientUtil.getUrl(swapper.getSwapperName());
                if(StringUtils.isNotBlank(url)){
                    swapper.setSwapperUrl(url);
                    list.add(swapper);
                }
            }
        }

        if(list.size() > 0){
            baseResult = BaseResult.success("ok",list);
        }
        return baseResult;
    }
}
