package spring.boot.demo.yml.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class User1 {
    @Value("${user.name}")
    private String name;
    @Value("#{2*2}")
    private Integer age;
    private Date createTime;
    @Value("true")
    private Boolean enable;
    private Map<String,Object> map;
    private List<Object> list;
    private List<Object> list1;
    private List<Dog> list2;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public List<Object> getList1() {
        return list1;
    }

    public void setList1(List<Object> list1) {
        this.list1 = list1;
    }

    public List<Dog> getList2() {
        return list2;
    }

    public void setList2(List<Dog> list2) {
        this.list2 = list2;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                ", enable=" + enable +
                ", map=" + map +
                ", list=" + list +
                ", list1=" + list1 +
                ", list2=" + list2 +
                ", dog=" + dog +
                '}';
    }
}
