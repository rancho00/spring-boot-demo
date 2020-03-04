package spring.boot.demo.scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务
 */
@EnableScheduling
@SpringBootApplication
public class ScheduledApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class);
    }
}
