package spring.boot.demo.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//必须是web引用
@ConditionalOnWebApplication
//激活HelloProperties文件
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    //申明HelloService bean对象
    @Bean
    public HelloService helloService(HelloProperties helloProperties){
        HelloService helloService=new HelloService(helloProperties);
        return  helloService;
    }
}
