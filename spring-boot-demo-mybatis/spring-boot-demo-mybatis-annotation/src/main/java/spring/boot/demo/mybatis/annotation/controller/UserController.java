package spring.boot.demo.mybatis.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.demo.mybatis.annotation.entity.User;
import spring.boot.demo.mybatis.annotation.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        return userMapper.getById(id);
    }

    @PostMapping
    public User save(User user){
        userMapper.save(user);
        return user;
    }
}
