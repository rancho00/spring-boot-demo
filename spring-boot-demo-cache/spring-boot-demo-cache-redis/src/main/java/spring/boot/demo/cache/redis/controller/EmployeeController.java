package spring.boot.demo.cache.redis.controller;

import spring.boot.demo.cache.redis.entity.Employee;
import spring.boot.demo.cache.redis.mapper.EmployeeMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeMapper employeeMapper;

    @RequestMapping("/get/{id}")
    @Cacheable(value = "employee",key = "#id")
    public Employee get(@PathVariable("id")Integer id){
        System.out.println("查询get");
        Employee employee=employeeMapper.get(id);
        return employee;
    }

    @RequestMapping("/update")
    @CachePut(value = "employee",key = "#employee.id")
    public Employee update(Employee employee){
        employee.setCreateTime(new Date());
        employeeMapper.update(employee);
        return employee;
    }

    @RequestMapping("/delete")
    @CacheEvict(value = "employee",key = "#id")
    public String update(Integer id){
        employeeMapper.delete(id);
        return "delete success";
    }
}
