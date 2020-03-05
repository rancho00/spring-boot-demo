package spring.boot.demo.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    /**
     * 监听ceshi.new路由，如果有消息就接受
     * @param map
     */
    @RabbitListener(queues = "ceshi.news")
    public void receive(Map<String,Object> map){
        System.out.println("收到消息："+map);
    }
}
