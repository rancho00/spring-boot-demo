package spring.boot.demo.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.boot.demo.bean.service.AnnotationHelloService;

@Configuration
public class BeanConfig {

    @Bean
    public AnnotationHelloService annotationHelloService(){
        return new AnnotationHelloService();
    }
}
