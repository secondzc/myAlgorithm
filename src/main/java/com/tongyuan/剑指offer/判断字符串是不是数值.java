package com.tongyuan.剑指offer;

/**
 * Created by zhangcy on 2018/7/24
 * 一种是科学计数法，可以带+- ，可以是.123(相当于0.123）
 */
public class 判断字符串是不是数值 {
    public static boolean isNum(String str){
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
