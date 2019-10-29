package com.rancho.demo.spring.boot.demo.cache.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class);
    }
}
