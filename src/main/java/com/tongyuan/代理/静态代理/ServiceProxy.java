package com.tongyuan.代理.静态代理;


import com.tongyuan.代理.HelloService;
import com.tongyuan.代理.RealService;

/**
 * Created by zhangcy on 2018/3/11
 */
public class ServiceProxy implements HelloService {
    private RealService realService = new RealService();
    @Override
    public String say(String name) {
        System.out.println("before say");
        String result = realService.say(name);
        System.out.println("after say");
        return result;
    }
}
