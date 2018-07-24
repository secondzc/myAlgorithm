package com.tongyuan.math;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/1/30
 * 一个只包含'A'、'B'和'C'的字符串，如果存在某一段长度为3的连续子串中恰好'A'、'B'和'C'各有一个，那么这个字符串就是纯净的，否则这个字符串
 * 就是暗黑的。例如：
 BAACAACCBAAA 连续子串"CBA"中包含了'A','B','C'各一个，所以是纯净的字符串
 AABBCCAABB 不存在一个长度为3的连续子串包含'A','B','C',所以是暗黑的字符串
 你的任务就是计算出长度为n的字符串(只包含'A'、'B'和'C')，有多少个是暗黑的字符串。
 输入描述:
 输入一个整数n，表示字符串长度(1 ≤ n ≤ 30)


 输出描述:
 输出一个整数表示有多少个暗黑字符串

 输入例子1:
 2 3

 输出例子1:
 9 21

这题其实是一个数学问题啊  目标：计算n位数中暗黑字符串的个数f(n)
 设n位数的暗黑字符串中后面两位相同的情况数为s(n),不同的情况数为d(n)  f(n) = s(n) + d(n) = 3*s(n-1) + 2*s(n-1) = 2*f(n-1) +s(n-1)
 n-2位数的后两位相同的暗黑字符串数量为s(n-2)，不同的暗黑字符串的数量为d(n-2)
 则有它们生成的暗黑字符创中，有s(n-2)+d(n-2)的相同,有 2*s(n-2)+d(n-2)不同
 所以 s(n-1) = s(n-2)+ d(n-2) = f(n-2)
 故  f(n) = 2* f(n-1) + f(n-2)
 */
public class 暗黑字符串的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = (int)Math.pow(3,n);
    }
}
