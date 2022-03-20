package com.sherwin.druid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/* @description: springboot application
 * @author: Sherwin Liang
 * @timestamp: 2022/3/20 10:50
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
