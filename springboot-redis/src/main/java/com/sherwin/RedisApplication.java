package com.sherwin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RedisApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RedisApplication.class)
                .properties("spring.config.location=classpath:/applicationRedis.properties")
                .build()
                .run(args);
    }
}
