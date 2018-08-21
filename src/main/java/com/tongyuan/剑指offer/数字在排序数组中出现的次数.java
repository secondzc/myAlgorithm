package com.tongyuan.剑指offer;

/**
 * Created by zhangcy on 2018/7/23
 * 找第一次出现的index的方法：若中位数不是k，则可以确定k在一边区间
 * 若中位数是k，则判断中位数前面是不是k，若不是，则中位数即为所求
 * 若是，则第一个k在前半部分区间
 */
public class 数字在排序数组中出现的次数 {
//    public static int getTimes(){
//
//    }
    public static int getFirstIndex(int[] nums,int k,int start ,int end){
        int index = nums.length/2;
        if(nums[index]<k){
            return getFirstIndex(nums,k,index,end);
        }else if(nums[index]>k){
            return getFirstIndex(nums,k,start,index);
        }else{
            if(index>=1 && nums[index-1]==k){
                return index;
            }else {
                return getFirstIndex(nums,k,start,index);
            }
        }
    }
//    public static int getLastIndex(int[] nums,int k){
//
//    }
}
