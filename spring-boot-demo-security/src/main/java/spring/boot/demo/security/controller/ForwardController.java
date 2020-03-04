package spring.boot.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forward")
public class ForwardController {

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("toRole1")
    public String toRole1(){
        return "role1";
    }

    @RequestMapping("toRole2")
    public String toRole2(){
        return "role2";
    }
}
