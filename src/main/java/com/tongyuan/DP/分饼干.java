package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/1/25
 * 易老师购买了一盒饼干，盒子中一共有k块饼干，但是数字k有些数位变得模糊了，看不清楚数字具体是多少了。易老师需要你帮忙把这k块饼干平
 * 分给n个小朋友，易老师保证这盒饼干能平分给n个小朋友。现在你需要计算出k有多少种可能的数值
 输入描述:
 输入包括两行：
 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
 第二行为小朋友的人数n


 输出描述:
 输出k可能的数值种数，保证至少为1

 输入例子1:
 9999999999999X 3

 输出例子1:
 4

 dp问题，能整除就是余数为0，取i为前i位数字的情况，关键是找到前i位和前i+1位之间的联系，有什么联系呢？记j为前i位%n, 则前i+1位%n 为
 jnew = （j*10+最后一位数字）%n ，反复往下算就可以了, dp表示符合的数的个数

 j是前i位除以n的余数，dp为i，j情况下的组合个数
 str表示的是一组数
 */
import java.util.Scanner;
public class 分饼干 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        int length = str.length();
        int[][] dp = new int[length+1][n];
        dp[0][0]=1;
        for(int i=1;i<=length;i++){
            char ch = str.charAt(i-1);
            int newj;
            if(ch=='X'){
                for(int j=0;j<n;j++){
                    for(int k=0;k<10;k++){
                        newj = (j*10+k)%n;
                        dp[i][newj] += dp[i-1][j];
                    }
                }
            }else{
                int endNum = str.charAt(i-1)-'0';
                for(int j=0;j<n;j++){
                    newj = (j*10+endNum)%n;
                    dp[i][newj] += dp[i-1][j];
                }
            }
        }
        System.out.println(dp[length][0]);
    }
}

