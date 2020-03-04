package spring.boot.demo.scheduled.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Scheduled(cron = "0/5 * * * * ?")
    public void handle(){
        System.out.println("处理成功...");
    }
}
