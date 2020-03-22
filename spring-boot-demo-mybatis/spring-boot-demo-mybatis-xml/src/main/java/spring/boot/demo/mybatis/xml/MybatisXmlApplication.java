package spring.boot.demo.mybatis.xml;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "spring.boot.demo.mybatis.xml.mapper")
public class MybatisXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisXmlApplication.class,args);
    }
}
