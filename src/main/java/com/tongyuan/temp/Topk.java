package com.tongyuan.temp;

/**
 * Created by zhangcy on 2018/8/19
 */
public class Topk {
    //最大的topk，要用到大小为topk的最小堆
    public int[] getTopk(int[] nums,int topk){
        MinHeap heap = new MinHeap();
        int[] heapNums = new int[topk];
        for (int i = 0; i < topk; i++) {
            heapNums[i] = nums[i];
        }
        heap.build(heapNums);
        //插入剩下的数
        for (int i = topk; i < nums.length; i++) {
            heap.add(heapNums,nums[i]);
        }
        return heapNums;
    }
    public static class MinHeap{
        public static void add(int[] nums,int num){
            if(num>nums[0]){
               nums[0] = num;
               adjust(nums,0);
            }
        }
        public static void adjust(int[] nums, int index){
            int tmp = nums[index];
            //每次从左子节点开始
            for (int i = 2*index+1; i < nums.length; i=i*2+1) {
                if(i+1<nums.length && nums[i+1]>nums[i]){
                    i++;
                }
                if(nums[i]>tmp){
                   nums[index] = nums[i];
                   index = i;
                }else{
                    break;
                }
            }
        }
        public static void build(int[] nums){
            for (int i = nums.length/2-1 ; i >=0; i--) {
                adjust(nums,i);
            }
        }
    }

}
