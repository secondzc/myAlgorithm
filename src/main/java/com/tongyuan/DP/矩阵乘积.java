package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/6/6
 * 输入一个二维数组p[i][0]=m，p[i][1]=n,表示第i个m*n的矩阵
 * dp[i][j]表示下标为i到j之间的矩阵加括号之后的乘积次数
 * dp[i][j] = min{ dp[i][k] + dp[k+1][j] + p[i][0]*p[k][1]*p[j][1] } ,i<j,i<=k<j
 *          = 0,i=j
 *
 */
public class 矩阵乘积 {
    /**
     计算的顺序是 dp[0][0] dp[1][1]...
    dp[0][1] dp[1][2]...
     dp[0][2] dp[1][3]...
     ...
     dp[0][n-1]
     */
}
