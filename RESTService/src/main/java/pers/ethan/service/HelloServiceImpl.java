package pers.ethan.service;

/**
 * desc:
 * Created by huangzhe on 2017/4/16.
 */
public class HelloServiceImpl implements HelloService {

    public String sayHello(String id) {
        return "hello "+ id;
    }
}
