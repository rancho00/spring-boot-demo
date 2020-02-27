package com.rancho.demo.spring.boot.demo.cache.controller;

import com.rancho.demo.spring.boot.demo.cache.entity.Employee;
import com.rancho.demo.spring.boot.demo.cache.repository.EmployeeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeRepository employeeRepository;

    @RequestMapping("/get")
    @Cacheable(value = "employee",key = "#id")
    public Employee get(Integer id){
        System.out.println("查询get");
        Employee employee=employeeRepository.getOne(id);
        return employee;
    }

    @RequestMapping("/update")
    @CachePut(value = "employee",key = "#employee.id")
    public Employee update(Employee employee){
        employee.setCreateTime(new Date());
        employee=employeeRepository.saveAndFlush(employee);
        return employee;
    }

    @RequestMapping("/delete")
    @CacheEvict(value = "employee",key = "#id")
    public Employee update(Integer id){
        return null;
    }
}
