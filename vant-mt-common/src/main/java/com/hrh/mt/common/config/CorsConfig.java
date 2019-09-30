package com.hrh.mt.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName: lqgxwd
 * @Package: org.lanqiao.config
 * @ClassName: CorsConfig
 * @Author: hrh
 * @Description: 跨域问题
 * @Date: 2019/5/27 0027 上午 11:16
 * @Version: 1.0
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE","OPTIONS")
                .allowCredentials(false).maxAge(3600);
    }
}
