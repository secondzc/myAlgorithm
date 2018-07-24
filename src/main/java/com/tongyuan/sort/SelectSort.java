package com.tongyuan.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangcy on 2018/4/2
 * 和插入排序的区别是：插入排序是插入到i+1前i个已经排好序的序列中，选择排序是每次选择i+1以后的元素中的最小值放入第i位置
 * 时间复杂度:
 *   最优:升序,O(N^2)
 *   最坏:降序,O(N^2)
 *   平均:O(N^2)
 * 空间复杂度:O(1)
 * 稳定性：如果在数组中交换，不稳定
 * 如果是新开一个数组，稳定
 */
public class SelectSort {
    public static void sort(int[] nums){
        int length = nums.length;
        for(int i=0;i<length;i++){
            int minIndex = i;
            for(int j=i+1;j<length;j++){
                if(nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {3,3,4,5,8,2,7 };
//        sort(nums);
//        System.out.println(Arrays.toString(nums));
        Map<String,Object> h = new HashMap<>();
        h.put(null,"is god");
        System.out.println(h.get(null));
    }
}
