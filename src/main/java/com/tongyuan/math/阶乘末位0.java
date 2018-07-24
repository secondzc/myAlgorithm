package com.tongyuan.math;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/1/29
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 输入描述:
 输入为一行，n(1 ≤ n ≤ 1000)


 输出描述:
 输出一个整数,即题目所求

 输入例子1:
 10

 若n！= 2^a * 5^b * ...    则答案为f = min(a,b),
 其实a肯定大于b，因为是从1×到n

 */
public class 阶乘末位0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num;
        int count = 0;
        for(int i=1;i<=n;i++){
            num = i;
            while(num%5==0){
                num/=5;
                count++;
            }
        }
        System.out.println(count);
    }
}
