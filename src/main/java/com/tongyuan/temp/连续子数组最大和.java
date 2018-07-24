package com.tongyuan.temp;

/**
 * Created by zhangcy on 2018/7/23
 *
 dp[i]表示以下标i结束的子数组的最大和（可能为负数）
 dp[i] = max(dp[i-1],0)+a[i]

 */
public class 连续子数组最大和 {
    public static int max(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],0) + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5};
        System.out.println(max(arr));
    }
}
