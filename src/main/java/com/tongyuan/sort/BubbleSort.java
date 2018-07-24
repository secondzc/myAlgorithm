package com.tongyuan.sort;

import java.util.Arrays;

/**
 * Created by zhangcy on 2018/3/31
 * 稳定性:稳定
 * 时间复杂度:
 *   最好:序列是升序O(N);
 *   最坏:序列式降序O(N^2);
 *   平均:O(N^2);
 * 空间复杂度:O(1)
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        int length = nums.length;
        boolean isSorted = false;
        for(int i=0;i<length&&!isSorted;i++){
            for(int j=0;j<length-1-i;j++){
                isSorted = true;
                if(nums[j]>nums[j+1]){
                    isSorted = false;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4, 5, 8, 2, 7};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
