package spring.boot.demo.scheduled.controller;

import spring.boot.demo.scheduled.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        helloService.handle();
        return "hello";
    }
}
