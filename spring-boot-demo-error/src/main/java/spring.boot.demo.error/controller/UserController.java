package spring.boot.demo.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/listUsers")
    @ResponseBody
    public String ListUsers(String userName){
        if("aaa".equals(userName)){
            Integer.parseInt(userName);
        }
        return "list users";
    }
}
