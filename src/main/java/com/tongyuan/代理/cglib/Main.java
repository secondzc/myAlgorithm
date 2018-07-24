package com.tongyuan.代理.cglib;

import com.tongyuan.代理.RealService;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangcy on 2018/7/17
 */
public class Main {
    public static void main(String[] args) {
        MyInterceptor myInterceptor = new MyInterceptor(new RealService());
        RealService realService = (RealService) myInterceptor.createProxy();
        realService.say("zzz");
    }
}
