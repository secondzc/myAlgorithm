package com.tongyuan.剑指offer;

/**
 * Created by zhangcy on 2018/7/24
 * k的范围是n-6n，取数组为0-6n
 * 求概率，总情况数为6^n，只需要求和为k的情况数
 * 数组表示有i个骰子时，点数和为k的情况数f（k）=f(k-1)+....+f(k-6)，用两个数组，使用哪个数组用flag来标识
 */
public class 求n个骰子点数和为k的概率 {
    // n骰子数， k为和的值
    public static void getProbabTimes(int n,int k){
        int[] times1 = new int[6*n+1];
        int[] times2 = new int[6*n+1];
        boolean flag = true; //当前是否在使用times1 数组
        for (int i = 1; i <= 6; i++) {
            times1[i] = 1;
        }
        int t = 1;
        while(t<k){
            for (int i = t; i < 6*t; i++) {
                for (int j = 1; j < 6 && i>=j; j++) {
                    if(flag){
                        times2[i] = times1[i-j];
                    }else {
                        times1[i] = times2[i-j];
                    }
                }
            }
        }
        // 输出当前使用的数组，除以总情况树，即可得到各个值的概率
    }

}
