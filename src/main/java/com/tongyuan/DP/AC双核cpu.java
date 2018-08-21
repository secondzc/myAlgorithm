package com.tongyuan.DP;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/1/23
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个
 * 核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 输入描述:
 输入包括两行： 第一行为整数n(1 ≤ n ≤ 50) 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个
 数均为1024的倍数。


 输出描述:
 输出一个整数，表示最少需要处理的时间

 输入例子1:
 5 3072 3072 7168 3072 1024

 输出例子1:
 9216

 双核

 就是背包问题，背包大小为总数/2，在不超过这个大小的前提下，装尽量多
 a[i]为第i-1个任务消耗的时间

 j为背包大小，i为在前i个货物中做选择，dp为在这种情况下的最大收益
 若第i个背包被选中，则其他背包的选择情况可转化到dp[i-1,j-a[i]]
 若第i个背包没有选，则相当于背包大小不变，在前i-1个之中选择

 若j-a[i]<0,则dp[i,j]=dp[i-1,j]
 否则
 dp[i,j]=dp[i-1,j-a[i]]+a[i] 和 dp[i,j]=dp[i-1,j] 之中的较大值

 dp[0,j]=dp[i,0]=0
 */
public class AC双核cpu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n+1];
        //背包容量
        int cap=0;
        for(int i=1;i<=n;i++){
            a[i] = sc.nextInt()/1024;
            cap+=a[i];
        }
        int realCap = cap;
        cap/=2;
        int[][] dp=new int[n+1][cap+1];
        for(int i=0;i<=cap;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=cap;j++){
                if(j-a[i]<0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int case1 = dp[i-1][j-a[i]]+a[i];
                    int case2 = dp[i-1][j];
                    dp[i][j] = (case1>case2)?case1:case2;
                }
            }
        }
        System.out.println((realCap-dp[n][cap])*1024);
    }
}
