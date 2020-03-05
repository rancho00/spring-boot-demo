package spring.boot.demo.rabbitmq;

import spring.boot.demo.rabbitmq.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 系统管理组件
     */
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void create(){
        //创建exchange
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        //创建queue
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
        //创建绑定
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqpAdmin.queue",null));
    }

    /**
     * 1.点对点<br>
     */
    @Test
    public void sendDirect(){
        /**
         * message需要自定义
         */
        //rabbitTemplate.send(exchange,routeKey,message);
        /**
         * message为Object
         */
        Map<String,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("message","操作成功");
        Student student=new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(22);
        map.put("data",student);
        rabbitTemplate.convertAndSend("exchange.direct","ceshi.news",map);
    }

    @Test
    public void receiveDirect(){
        Map map=(Map) rabbitTemplate.receiveAndConvert("ceshi.news");
        System.out.println(map);
    }

    /**
     * 广播
     */
    @Test
    public void sendFanout(){
        Map<String,Object> map=new HashMap<>();
        map.put("code",200);
        map.put("message","操作成功");
        Student student=new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(22);
        map.put("data",student);
        rabbitTemplate.convertAndSend("exchange.fanout","",map);
    }

    @Test
    public void receiveFanout(){
        Map map=(Map) rabbitTemplate.receiveAndConvert("ceshi.news");
        System.out.println(map);
    }
}
