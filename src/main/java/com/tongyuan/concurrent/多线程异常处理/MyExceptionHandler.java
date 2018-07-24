package com.tongyuan.concurrent.多线程异常处理;

/**
 * Created by zhangcy on 2018/7/17
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caght " + e);
    }
}
