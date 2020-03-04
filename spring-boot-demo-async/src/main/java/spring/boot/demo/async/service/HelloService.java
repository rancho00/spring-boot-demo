package spring.boot.demo.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Async
    public void handle(){
        try {
            Thread.sleep(3000);
            System.out.println("处理成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
