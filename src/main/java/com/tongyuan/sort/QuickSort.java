package com.tongyuan.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangcy on 2018/7/20
 * 快速排序的实现
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{66,13,51,76,81,26,57,69,23};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void quickSort(int[] nums,int start,int end) {
        if(start>=end){
            return ;
        }
        //以第一个元素为划分基准
        int i = start;
        int j = end;
        int k = start;
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
        quickSort(nums,start,k-1);
        quickSort(nums,k+1,end);
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
