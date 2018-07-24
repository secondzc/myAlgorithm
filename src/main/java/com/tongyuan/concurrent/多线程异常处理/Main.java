package com.tongyuan.concurrent.多线程异常处理;

/**
 * Created by zhangcy on 2018/7/17
 */
public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler(new MyExceptionHandler());
        myThread.start();

    }
}
