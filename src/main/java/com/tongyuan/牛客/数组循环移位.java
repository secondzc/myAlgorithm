package com.tongyuan.牛客;

/**
 * Created by zhangcy on 2018/8/19
 * 大小为n位的数组，向右移k位
 * 0到(n-k-1) 逆序
 * n-k到n-1 逆序
 * 整个逆序
 */
public class 数组循环移位 {
    public static void move(int[] nums,int k){
        k %= nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }
    public static void reverse(int[] nums,int start,int end){
        int i=start;
        int j=end;
        for (;i<j;i++,j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
