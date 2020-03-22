package spring.boot.demo.mybatis.xml.mapper;

import org.apache.ibatis.annotations.*;
import spring.boot.demo.mybatis.xml.entity.User;

@Mapper
public interface UserMapper {

    User getById(Integer id);

    int delete(Integer id);

    int save(User user);

    int update(User user);
}
