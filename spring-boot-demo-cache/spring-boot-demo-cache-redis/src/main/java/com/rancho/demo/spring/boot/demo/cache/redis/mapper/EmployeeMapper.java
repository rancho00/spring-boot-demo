package com.rancho.demo.spring.boot.demo.cache.redis.mapper;

import com.rancho.demo.spring.boot.demo.cache.redis.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    Employee get(Integer id);

    @Update("update employee set name=#{name} where id=#{id}")
    void update(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void delete(Integer id);
}
