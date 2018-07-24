package com.tongyuan.代理;



/**
 * Created by zhangcy on 2018/3/11
 */
public class RealService implements HelloService{

    @Override
    public String say(String name) {
        return "hello "+ name;
    }
}
