package spring.boot.demo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //开启springSecurity登陆功能，没有权限时会跳该页面
        http.formLogin();
        //开启springSecurity注销功能
        http.logout().logoutSuccessUrl("/forward/toIndex");
        //请求认证
        http.authorizeRequests().antMatchers("/forward/toIndex").permitAll()
                .antMatchers("/forward/toRole1").hasRole("role1")
                .antMatchers("/forward/toRole2").hasRole("role2");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //springSercurity 5.x必须声明加密方式
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("rancho").password(new BCryptPasswordEncoder().encode("123456")).roles("role1");
    }
}
