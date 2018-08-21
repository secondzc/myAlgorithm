package com.tongyuan.sort;

/**
 * Created by zhangcy on 2018/8/19
 * topk用快速排序实现
 */
public class Topk {
    public static int[] topk(int[] nums,int topk){
        quickSort(nums,0,nums.length,topk);
        //遍历0-（topk-1）输出
        int[] result = new int[topk];
        for (int i = 0; i < topk; i++) {
            result[i] = nums[i];
        }
        return result;
    }

    public static void quickSort(int[] nums,int start,int end,int topk) {
        if(start>=end || start>topk){
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
        quickSort(nums,start,k-1,topk);
        quickSort(nums,k+1,end,topk);
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
