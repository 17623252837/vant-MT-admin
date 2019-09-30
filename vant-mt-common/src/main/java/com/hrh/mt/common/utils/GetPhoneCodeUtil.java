package com.hrh.mt.common.utils;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 手机验证码处理工具类   未做号码验证
 */
@Component
public class GetPhoneCodeUtil {

    //获取验
    public static boolean getCode(String phone,String code){
        String host = "http://yzx.market.alicloudapi.com";
        String path = "/yzx/sendSms";
        String method = "POST";
        String appcode = "859fb419742e4a65b219b15ac5dc64d0";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        querys.put("param", "code:" + code);
        querys.put("tpl_id", "TP1710262");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtil.doPost(host, path, method, headers, querys, bodys);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
