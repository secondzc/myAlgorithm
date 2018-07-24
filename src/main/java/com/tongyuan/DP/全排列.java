package com.tongyuan.DP;

import java.util.Scanner;

/**
 * Created by zhangcy on 2018/1/23
 * 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
 输入描述:
 输入包括一行,包含两个整数n和k(k < n ≤ 1000)


 输出描述:
 输出满足条件的排列数,答案对2017取模。

 输入例子1:
 5 2

 输出例子1:
 66

 dp[i][j]表示大于符号个数和总数字个数为i、j的情况下的排列种数 i<=j-1
 dp[0][x]=1  dp[x][x+1]=1
 若增加一个数和一个大于号，则放在最前面，或插入中间小于号的地方
 若增加一个数和一个<，则放在最后面，或插入中间>的地方
 dp[i][j]=dp[i-1][j-1]*(j-i)+dp[i][j-1]*(i+1)
 */
public class 全排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //总数
        int n = sc.nextInt();
        //大于号的个数
        int k = sc.nextInt();
        long[][] dp=new long[n+1][n+1];
        for(int j=1;j<=n;j++){
            dp[0][j]=1;
            dp[j-1][j]=1;
        }
        if(n==1){
            System.out.println(1);
        }else if(n==2){
            System.out.println(dp[k][n]);
        }else{
            for(int j=3;j<=n;j++){
                for(int i=1;i<=j-2;i++){
                    dp[i][j]=dp[i-1][j-1]*(j-i)+dp[i][j-1]*(i+1);
                }
            }
            System.out.println(dp[k][n]%2017);
        }
    }
}
