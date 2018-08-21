package com.tongyuan.剑指offer;

/**
 * Created by zhangcy on 2018/7/17
 */
public class 二进制数字中1的个数 {
    // 解法1:
//    public static int numCount(int num) {
//        int i = 1;
//        int count=0;
//        while(i != 0) {
//            if ((num & i) != 0) {
//                count++;
//            }
//            i = i<<1;
//        }
//        return count;
//    }

    //解法2：将一个数减1与原数进行按位与，相当于把最后一位1变成0，做几次就有几个1
    public static int numCount(int num) {
        int count = 0;
        while(num != 0) {
            count++;
            num = (num-1) & num;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(numCount(11));
    }
}
