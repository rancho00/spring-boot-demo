package com.rancho.demo.spring.boot.demo.starter.controller;


import com.rancho.demo.spring.boot.demo.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
