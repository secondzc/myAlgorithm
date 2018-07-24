package com.tongyuan.designPattern.watch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangcy on 2018/1/25
 */

public class Account implements Subject{

    private int state;
    private String name;

    public String getName() {
        return name;
    }
    public Account(String name) {
        super();
        this.name = name;
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (this.state != state) {
            this.state = state;
            notifyObservers();
        }
    }
    @Override
    public String toString() {
        return name;
    }

    private Set<Observer> observers = new HashSet<>();
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}

