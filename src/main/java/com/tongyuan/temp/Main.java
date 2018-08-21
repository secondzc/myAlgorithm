package com.tongyuan.temp;

/**
 * Created by zhangcy on 2018/8/13
 */
public class Main {
    public static void main(String[] args) {
//        Integer a = 125;
//        Integer b=125;
//        Integer c = 321;
//        Integer d = 321;
//        System.out.println(a==b);//true
//        System.out.println(c==d);//false
        int a = 3;
        Integer b = 3;
        Integer c = new Integer(3);
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);// b是放在cache中的，c是new出来的，所以不相等
    }
}
