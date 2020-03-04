package spring.boot.demo.spring.data.elasticsearch.repository;

import spring.boot.demo.spring.data.elasticsearch.repository.entity.User;
import spring.boot.demo.spring.data.elasticsearch.repository.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Resource
    private UserService userService;

    @Test
    public void add(){
        try{
            User user=new User();
            user.setId("20190909");
            user.setName("测试");
            user.setAge(22);
            userService.save(user);
            System.out.println("添加成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void get(){
        try{
            User user=userService.getById("20190909");
            System.out.println(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void update(){
        try{
            User user=new User();
            user.setId("20190909");
            user.setName("测试-update");
            user.setAge(22);
            userService.update(user);
            System.out.println("修改成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getByName(){
        try{
            User user=userService.getByName("测试-update");
            System.out.println(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void delete(){
        try{
            userService.delete("20190909");
            System.out.println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
