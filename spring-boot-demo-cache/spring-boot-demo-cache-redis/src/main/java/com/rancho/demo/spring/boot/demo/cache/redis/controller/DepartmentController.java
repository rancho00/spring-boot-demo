package com.rancho.demo.spring.boot.demo.cache.redis.controller;

import com.rancho.demo.spring.boot.demo.cache.redis.entity.Department;
import com.rancho.demo.spring.boot.demo.cache.redis.mapper.DepartmentMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    RedisTemplate<Object, Object> redisTemplate;

    @RequestMapping("/get/{id}")
    public Department get(@PathVariable("id")Integer id){
        Department department=(Department)redisTemplate.opsForValue().get(String.valueOf(id));
        if(department!=null){
            return department;
        }
        System.out.println("department查询get");
        department = departmentMapper.get(id);
        //插入redis
        redisTemplate.opsForValue().set(String.valueOf(id), department);
        return department;
    }
}
