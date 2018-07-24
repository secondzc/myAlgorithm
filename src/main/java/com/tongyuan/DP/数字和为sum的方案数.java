package com.tongyuan.DP;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/1/30
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 输入描述:
 输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。


 输出描述:
 输出所求的方案数

 输入例子1:
 5 15
 5 5 10 2 3

 输出例子1:
 4

 dp[i][j]表示前j个数字中取若干个数字，和为i的方案数

 dp的又一个感悟：j表示选择的是前j个数字，这个没问题，dp表示方案数， 关键是i，题目求的是前j个数得到和为sum的方案数，
 这里转化为前j个数得到和为i的方案数，注意dp往往会求得一个比想要的结果更大的集合，比方说求和为sum，我们可以求和为1，2，3...sum，
 比方之前有个题目求余数为0，我们可以求余数为0,1,2,3....

 若没选第j个数，则方案数相同，若选了第j个数，则方案数还要加上一种情况。
 dp[i][j] = dp[i-a[j-1]][j-1] + dp[i][j-1]     dp[0][j] = 1, dp[i][0] =0(其中i!=0）
 每一层只是依赖上一层，可以转成两个一维数组
 dp2[i] = dp1[i-a[j-1]] + dp1[i];
 观察可知，如果从后往前计算，甚至都不需要用辅助数组dp1，直接在原数组上计算就可以了
 */
public class 数字和为sum的方案数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[] dp2 = new int[sum+1];
        int[] dp1 = new int[sum+1];
        dp1[0] = 1;
        for(int k=1;k<=n;k++){
            dp2[0] = 1;
            for(int i=1;i<=sum;i++){
                dp2[i] = dp1[i] + (i-a[k-1]<0 ? 0 : dp1[i-a[k-1]]);
            }
            int[] temp = dp2;
            dp2 = dp1;
            dp1 = temp;
            for(int i=0;i<=sum;i++){
                dp2[i] = 0;
            }
        }
        //这是已经到第k层，也就是要求得和sum的层数
        System.out.println(dp1[sum]);
    }
}
