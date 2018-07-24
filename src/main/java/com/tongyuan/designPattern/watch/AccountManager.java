package com.tongyuan.designPattern.watch;

/**
 * Created by zhangcy on 2018/1/25
 * 观察者是知道被观察者的信息的，所以传进来subject之后可以转化成Account
 */
public class AccountManager implements Observer{

    public void sendEmail(Account account) {
        System.out.println("send Email:"+ account);
    }
    @Override
    public void update(Subject subject) {
        sendEmail((Account) subject);
    }
}
