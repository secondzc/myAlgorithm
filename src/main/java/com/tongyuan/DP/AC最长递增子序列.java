package com.tongyuan.DP;

/**
 * Created by zhangcy on 2018/8/6
 * 有两种方式来求解，一种是转化为LCS问题。即，首先对数组排序，将排序后的结果存储在辅助数组中。排序时间复杂度O(NlogN)，排序后的数组与原数组组成了LCS（N,N）问题。解决LCS问题的时间复杂度为O(N^2)，故整个算法的时间复杂度为O(N^2)，空间复杂度为O(N)

 另一种方式是直接用DP求解，算法如下：时间复杂度为O(N^2)

 ①最优子问题

 设lis[i] 表示索引为 [0...i] 上的数组上的 最长递增子序列。初始时，lis[i]=1，注意，在DP中，初始值是很重要的，它是整个算法运行正确的关键。而初始值 则可以 通过 画一个小的示例来 确定。

 当 arr[i] > arr[j]，lis[i] = max{lis[j]}+1 ；其中，j 的取值范围为：0,1...i-1

 当 arr[i] < arr[j]，lis[i] = max{lis[j]} ；其中，j 的取值范围为：0,1...i-1

(上面表达的的不清楚，应该是dp[i]=max{dp[j]或者dp[j]+1},根据arr[i] 和 arr[j]判断是否+1)
 */
public class AC最长递增子序列 {
    public static int max(int[] str1){
        int length = str1.length;
        if(length<=0){
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int[] tmp = new int[length];
            for (int j = 0; j <= i-1; j++) {
                if(str1[i]>=str1[j]){ //允许非严格递增
                    tmp[j] = dp[j]+1;
                }else{
                    tmp[j] = dp[j];
                }
            }
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i-1; j++) {
                if(tmp[j]>max){
                    max = tmp[j];
                }
            }
            dp[i] = max;
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        int[] str1 = {1,2,3,2,4,5,6,9,8,7};
        System.out.println(max(str1));
    }
}
