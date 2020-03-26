package spring.boot.demo.properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.boot.demo.properties.bean.User;
import spring.boot.demo.properties.bean.User1;
import spring.boot.demo.properties.bean.User2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private User1 user1;

    @Autowired
    private User2 user2;

    @Test
    public void contextLoads(){
        System.out.println(user);
        //System.out.println(user1);
        //System.out.println(user2);
    }
}
