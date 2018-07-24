package com.tongyuan.代理.动态代理;



import com.tongyuan.代理.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhangcy on 2018/3/11
 */
public class ProxyHandler implements InvocationHandler {

    public Object getProxy() throws Exception{
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class<?>[]{HelloService.class},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("say other");
        Object result = "this is result from remote";
        return result;
    }
}
