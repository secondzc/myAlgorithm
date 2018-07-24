package com.tongyuan.代理.动态代理;


import com.tongyuan.代理.HelloService;

/**
 * Created by zhangcy on 2018/3/11
 */
public class Main {
    public static void main(String[] args) throws Exception{
        ProxyHandler proxyHandler = new ProxyHandler();
        HelloService helloService = (HelloService) proxyHandler.getProxy();
        System.out.println(helloService.say("zcy"));
    }
}
