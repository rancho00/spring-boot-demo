package spring.boot.demo.starter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.demo.autoconfigure.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return helloService.sayHello();
    }
}
