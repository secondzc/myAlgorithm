package com.tongyuan.代理.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhangcy on 2018/7/17
 * cglib代理对象是目标对象的子类，拦截器实现了MethodInterceptor接口
 */
public class MyInterceptor implements MethodInterceptor {
    private Object target;

    public MyInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        method.invoke(this.target, args);
        System.out.println("after");
        return null;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);//回调函数  拦截器
        //设置代理对象的父类,可以看到代理对象是目标对象的子类。所以这个接口类就可以省略了。
        enhancer.setSuperclass(this.target.getClass());
        return enhancer.create();
    }

}
