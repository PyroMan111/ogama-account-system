package com.xeno.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.util.Collections;

public class CodeGenerator2 {
    public static void main(String[] args) {
//修改url username password
        FastAutoGenerator.create("jdbc:mysql://192.168.80.9:3306/info_system_test","root", "root")
                .globalConfig(builder -> {
                    builder
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.ONLY_DATE).disableOpenDir()
                            .outputDir("D:\\IDEA\\IdeaProject\\p3-w1-first\\p3-w1\\info-system-parent\\info-sys-info\\src\\main\\java");
                    // 指定输出目录
//                                      D:\IDEA\IdeaProject\p3-w1-first\p3-w1\D3-w5-health-sys\h-portal\src\main\java
                }).packageConfig(builder -> {
                    builder.parent("com.wnxy.sys.info") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                                "D:\\IDEA\\IdeaProject\\p3-w1-first\\p3-w1\\info-system-parent\\info-sys-info\\src\\main\\resources\\mapper"));
                    // 设置mapperXml生成路径
                }).strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle();
                    builder.addInclude("information","reply")
// 设置需要生成的表名
                            .addTablePrefix(""); // 设置过滤表前缀
                })
                .execute();
    }
}
