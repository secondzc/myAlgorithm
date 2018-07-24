package com.tongyuan.designPattern.watch;


/**
 * Created by zhangcy on 2018/1/25
 */
public class ObserveClient {

    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        AccountManager manager2 = new AccountManager();
        Account account = new Account("Account1");
        account.addObserver(manager);
        account.addObserver(manager2);
        account.setState(1);
    }
}
