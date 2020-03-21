package spring.boot.demo.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/list")
    public List<Map<String,Object>> list(){
        return jdbcTemplate.queryForList("select * from user");
    }
}
