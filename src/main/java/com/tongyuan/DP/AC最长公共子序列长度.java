package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/8/6
 * 子序列不一定是连续的
 * dp[i][j] = dp[i-1][j-1]+1 , if(a[i]==b[j])
 *         = max(dp[i-1][j], dp[i][j-1]) , else
 * dp[i][j]表示以i，j结束的子序列的最长公共子序列的长度
 */
public class AC最长公共子序列长度 {
    public static int maxSubSequence(int[] str1, int[] str2){
        int length1 = str1.length;
        int length2 = str2.length;
        int[][] dp = new int[length1][length2];
        for (int i = 0; i < length1-1; i++) {
            for (int j = 0; j < length2-1; j++) {
                if(str1[i]==str2[j]){
                    dp[i+1][j+1] = dp[i][j]+1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[length1-1][length2-1];
    }

    public static void main(String[] args) {
        int[] str1 = {1,3,5,7,9};
        int[] str2 = {1,2,3,4,5,6};
        System.out.println(maxSubSequence(str1,str2));
    }
}
