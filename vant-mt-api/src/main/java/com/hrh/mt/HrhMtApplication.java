package com.hrh.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hrh.mt.mapper")
public class HrhMtApplication {
    public static void main(String[] args) {
        SpringApplication.run(HrhMtApplication.class,args);
    }
}
