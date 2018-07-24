package com.tongyuan.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangcy on 2018/7/20
 * 一趟快速排序的实现
 */
public class QuickSortOnce {
    public static void main(String[] args) {
        int[] nums = new int[]{66,13,51,76,81,26,57,69,23};
        int[] nums1 = quickSortOnce(nums);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
    public static int[] quickSortOnce(int[] nums) {
        //以第一个元素为划分基准
        int i = 0;
        int j = nums.length-1;
        int k = 0;
        while(i<j){
            while(nums[j]>=nums[k] && i<j){
                j--;
            }
            swap(nums,j,k);
            k=j;
            while(nums[i]<=nums[k] && i<j){
                i++;
            }
            swap(nums,i,k);
            k=i;
        }
        return nums;
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
