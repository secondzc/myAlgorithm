package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/8/7
 * 物品的价值value[]  重量weight[]  背包容量 cap ，求最大价值
 * dp[i][j]表示前i个物品装进背包容量为j的最大价值
 * dp[i][j] = max{ dp[i-1][j-weight[i]]+value[i], dp[i-1][j] } , if j>=weight[i]
 *          = dp[i-1][j] , else
 * 理解就是，如果容量不够装第i个，则只能选前i-1个物品装进j容量
 * 如果能够装，上面式子分别表示装了第i件物品和没装第i件物品
 *
 * 初始化时，当i=0时的一列，表示选择了第0个物品，放进背包容量为j的最大价值，当weight[0]<=j时，dp[0][j]=value[0],否则dp[0][j]=0
 */
public class AC背包问题 {
    public static int maxValue(int[] value,int[] weight,int cap,int size){
        int[][] dp = new int[size][cap+1];
        for (int j = 0; j <= cap; j++) {
            if(weight[0]<=j){
                dp[0][j] = value[0];
            }else{
                dp[0][j] = 0;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= cap; j++) {
                if(j>=weight[i]){
                    dp[i][j] = Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[size-1][cap];
    }
}
