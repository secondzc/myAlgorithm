package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/8/6
 * 最长公共子串是连续的
 * https://blog.csdn.net/ranjiewen/article/details/52595623
 * dp[i][j] = dp[i-1][j-1]+1 , if(a[i]==b[j])
 *          = 0,    else
 * (还能得到最长公共子串的位置)
 */
public class AC最长公共子串长度 {
    public static int maxSubString(int[] str1, int[] str2){
        int length1 = str1.length;
        int length2 = str2.length;
        int[][] dp = new int[length1][length2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length1-1; i++) {
            for (int j = 0; j < length2-1; j++) {
                if(str1[i+1] == str2[j+1]){
                    dp[i+1][j+1] = dp[i][j]+1;
                    if(dp[i+1][j+1]>max){
                        max = dp[i+1][j+1];
                    }
                }else{
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] str1 = {1,2,3,4,5,6,7,8,9};
        int[] str2 = {3,2,4,5,6,7,1,9};
        System.out.println(maxSubString(str1,str2));
    }
}
