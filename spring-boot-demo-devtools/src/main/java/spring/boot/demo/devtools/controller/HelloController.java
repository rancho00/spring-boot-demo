package spring.boot.demo.devtools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    //@RequestMapping("/sayHello")
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
