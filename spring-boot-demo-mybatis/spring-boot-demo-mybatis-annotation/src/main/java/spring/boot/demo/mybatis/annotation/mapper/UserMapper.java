package spring.boot.demo.mybatis.annotation.mapper;

import org.apache.ibatis.annotations.*;
import spring.boot.demo.mybatis.annotation.entity.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where id=#{id}")
    User getById(Integer id);

    @Delete("delete from user where id=#{id}")
    int delete(Integer id);

    @Options(useGeneratedKeys = true,keyColumn = "id")
    @Insert("insert into user (username,mail) values (#{username},#{mail})")
    int save(User user);

    @Update("update user set username=#{username} where id=#{id}")
    int update(User user);
}
