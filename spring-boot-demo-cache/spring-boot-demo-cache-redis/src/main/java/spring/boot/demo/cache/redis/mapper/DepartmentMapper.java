package spring.boot.demo.cache.redis.mapper;

import spring.boot.demo.cache.redis.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department get(Integer id);
}
