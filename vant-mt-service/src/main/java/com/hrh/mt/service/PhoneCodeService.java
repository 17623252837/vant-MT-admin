package com.hrh.mt.service;

import com.hrh.mt.common.utils.BaseResult;

public interface PhoneCodeService {
    //获取验证码
    BaseResult getCode(String phone);
    //提交验证码
    BaseResult putCode(String phone,String code);
}
