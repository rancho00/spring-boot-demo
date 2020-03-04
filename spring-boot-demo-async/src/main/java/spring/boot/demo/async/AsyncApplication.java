package spring.boot.demo.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 异步执行
 */
@SpringBootApplication
@EnableAsync
public class AsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class);
    }
}
