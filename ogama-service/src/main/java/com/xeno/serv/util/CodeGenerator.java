package com.xeno.serv.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
//修改url username password
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db_game_account","root", "root")
                .globalConfig(builder -> {
                    builder
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.ONLY_DATE).disableOpenDir()
                            .outputDir("D:\\IDEA\\IdeaProject\\p3-w1-first\\p3-w1\\own-gamaccount-sys\\ogama-sso\\src\\main\\java");
                    // 指定输出目录
//                                      D:\IDEA\IdeaProject\p3-w1-first\p3-w1\D3-w5-health-sys\h-portal\src\main\java
                }).packageConfig(builder -> {
                    builder.parent("com.xeno.user") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                "D:\\IDEA\\IdeaProject\\p3-w1-first\\p3-w1\\own-gamaccount-sys\\ogama-sso\\src\\main\\resources\\mapper"));
                    // 设置mapperXml生成路径
                }).strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle();
                    builder.addInclude("ga_user")
// 设置需要生成的表名
                            .addTablePrefix("ga"); // 设置过滤表前缀
                })
                .execute();
    }
}
