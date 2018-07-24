package com.tongyuan.designPattern.watch;

/**
 * Created by zhangcy on 2018/1/25
 * 被观察者接口
 */
public interface Subject {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
