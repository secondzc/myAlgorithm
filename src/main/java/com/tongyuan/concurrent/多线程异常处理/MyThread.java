package com.tongyuan.concurrent.多线程异常处理;

/**
 * Created by zhangcy on 2018/7/17
 */
public class MyThread extends Thread {
    public void run() {
        throw new RuntimeException();
    }
}
