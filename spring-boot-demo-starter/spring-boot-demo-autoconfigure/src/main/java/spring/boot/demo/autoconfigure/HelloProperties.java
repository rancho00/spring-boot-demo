package spring.boot.demo.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

//获取配置文件rancho开头的属性
@ConfigurationProperties(prefix = "rancho")
public class HelloProperties {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
