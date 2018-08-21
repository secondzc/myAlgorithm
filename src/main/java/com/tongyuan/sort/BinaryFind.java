package com.tongyuan.sort;

/**
 * Created by zhangcy on 2018/7/25
 * 二分查找
 * https://www.cnblogs.com/luoxn28/p/5767571.html
 */
public class BinaryFind {
    public  static int find1(int[] nums,int key){
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
    /*
    查找第一个等于key的元素下标
     */
    public static int find2(int[] nums,int key){
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>=key){
                end = mid-1;
            }else if(nums[mid]<key){
                start = mid+1;
            }
        }
        if(start<nums.length && nums[start]==key){
            return start;
        }
        return -1;
    }
    /*
    查找最后一个小于等于key的元素下标
     */
    public static int find3(int[] nums,int key){
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>=key){
                end = mid-1;
            }else if(nums[mid]<key){
                start = mid+1;
            }
        }
        if(start<nums.length && nums[start]==key){
            return start;
        }
        return start-1;
    }

    public static void main(String[] args) {
        System.out.println(find1(new int[]{1,3,3,3,5},3));
        System.out.println(find2(new int[]{1,3,3,3,5},3));
        System.out.println(find3(new int[]{1,3,3,3,5},3));
        System.out.println(find3(new int[]{1,3,3,3,5},2));
    }
}
