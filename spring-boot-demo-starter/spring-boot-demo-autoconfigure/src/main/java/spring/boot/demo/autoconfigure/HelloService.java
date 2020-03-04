package spring.boot.demo.autoconfigure;

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
