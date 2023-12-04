package com.xeno.user;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class UserApplication {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(UserApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
        System.out.println("启动成功：http://localhost:6080");
    }
}