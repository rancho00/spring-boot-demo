package spring.boot.demo.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.demo.jpa.entity.User;
import spring.boot.demo.jpa.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userRepository.getOne(id);
    }

    @PostMapping
    public User save(){
        User user=new User();
        user.setUsername("RANCHO");
        user.setMail("www@qq.com");
        user=userRepository.save(user);
        return user;
    }
}
