package com.rancho.demo.spring.boot.demo.starter;

public class HelloService {

    private HelloProperties helloProperties;

    public HelloService(HelloProperties helloProperties){
        this.helloProperties=helloProperties;
    }

    public String sayHello(){
        System.out.println();
        return helloProperties.getUserName()+"：hello";
    }
}
