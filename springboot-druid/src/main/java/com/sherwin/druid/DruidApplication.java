package com.sherwin.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Haoxy on 2019-06-25.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
@SpringBootApplication
@MapperScan("com.sherwin.druid.mapper")
public class DruidApplication{

    public static void main(String[] args) {
        new SpringApplicationBuilder(DruidApplication.class)
                .properties("spring.config.name=applicationDruid")
                .build()
                .run(args);
    }
}
