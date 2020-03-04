package spring.boot.demo.staticresource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StaticresourceApplicaion extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StaticresourceApplicaion.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StaticresourceApplicaion.class);
    }
}
