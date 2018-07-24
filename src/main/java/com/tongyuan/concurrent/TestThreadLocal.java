package com.tongyuan.concurrent;

/**
 * Created by zhangcy on 2018/5/9
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> name = new ThreadLocal<>();
        ThreadLocal<Integer> age = new ThreadLocal<>();
        new Thread(){
            @Override
            public void run(){
                name.set("zcy");
                age.set(1);
                System.out.println(name.get()+age.get());
            }

        }.start();
        new Thread(){
            @Override
            public void run(){
                name.set("我是哈哈");
                age.set(2);
                System.out.println(name.get()+age.get());
            }

        }.start();
    }

}
