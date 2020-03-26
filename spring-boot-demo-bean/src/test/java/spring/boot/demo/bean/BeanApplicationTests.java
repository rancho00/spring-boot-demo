package spring.boot.demo.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanApplicationTests {

    @Autowired
    private ApplicationContext ioc;

    @Test
    public void contextLoaders(){
        System.out.println(ioc.containsBean("xmlHelloService"));
        System.out.println(ioc.containsBean("annotationHelloService"));
    }
}
