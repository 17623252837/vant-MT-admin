package com.hrh.mt.api;

import com.hrh.mt.common.utils.BaseResult;
import com.hrh.mt.service.PhoneCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
public class phoneCodeController {
    @Autowired
    private PhoneCodeService phoneCodeService;

    //获取验证码
    @GetMapping("/check/phone/{phone}")
    BaseResult getCode(@PathVariable String phone){
        return phoneCodeService.getCode(phone);
    }

    //提交验证码
    @PostMapping("/check/phone/{phone}/code/{code}")
    BaseResult putCode(@PathVariable String phone,@PathVariable String code){
        return phoneCodeService.putCode(phone,code);
    }
}
