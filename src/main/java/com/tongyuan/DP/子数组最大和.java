package com.tongyuan.DP;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/1/29
 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 输入描述:
 输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。


 输出描述:
 所有连续子数组中和最大的值。

 输入例子1:
 3
 -1 2 1

 输出例子1:
 3

动态规划：dp[i]表示最后一位数字是第i个数字的子数组的最大和,a[i-1]表示第i个数
 dp[i] = max(dp[i-1],0) + a[i-1]
 其实没必要用一个数组，因为只是用到了前一个位置的计算结果
 8
 -2 1 -3 4 -1 2 1 -5
 */
public class 子数组最大和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            dp[i] = Integer.max(dp[i-1],0) + a[i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        System.out.println(max);
    }


/* dp[i][0]表示前i个数的最大和
 * dp[i][1]表示前i个数的从最后开始的最大和（即要么包含最后一堆元素，要么为0）
* dp[i][3]标志是否包含最大和是否包含最后一个元素
 *
* if(dp[i][3]==true) 判断a[i-1] 是否大于0
 * 否则，dp[i][0] = max(dp[i-1][0] , dp[i][1]+max(a[i-1],0) )
*
* 这是我第二天想的，这个思路没有上面的思路好，上面的思路是把数组看成固定的，求以i结尾的数组的最大和，在求i=数组最后一位的特殊情况*/
}
