package com.tongyuan.剑指offer;

/**
 * Created by zhangcy on 2018/7/23
 * 时间效率为nlogn的算法： 排序找出现次数超过一半的数字
 * 几种种时间效率为n的算法
 * 1. 用hashmap
 * 2. 因为其他数字加起来也比此数字少，所以
 *   count，num如果读入的数字==num，则count++，否则count--，如果count==0，则记录num=下一个数字
 * 3. 用快速排序的思想
 */
public class 出现次数超过一半的数字 {
    public static int moreThanHalf(int[] nums){
        if(nums.length<=0){
            return -1;
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==result){
                count++;
            }else{
                count--;
            }
            if(count==0){
                result = nums[i];
                count=1;
            }
        }
        return result;
    }
}
