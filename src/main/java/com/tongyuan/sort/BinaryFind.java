package com.tongyuan.sort;

/**
 * Created by zhangcy on 2018/7/25
 * 二分查找
 */
public class BinaryFind {
    public  static int find(int[] nums,int key){
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>key){
                end = mid-1;
            }else if(nums[mid]<key){
                start = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
