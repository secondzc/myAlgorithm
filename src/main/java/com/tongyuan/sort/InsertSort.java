package com.tongyuan.sort;

import java.util.Arrays;

/**
 * Created by zhangcy on 2018/3/31
 * 时间复杂度:
 *   最好情况,序列已排序O(N);
 *   最坏情况.逆序O(N^2);
 *   平均O（N^2）
 * 空间复杂度:O(1)
 * 稳定性：稳定
 * 优化改进
 *   1.二分查找插入排序：因为在一个有序区中查找一个插入位置，所以可使用二分查找，减少元素比较次数提高效率。
 *   2.希尔排序：如果序列本来就是升序或部分元素升序，那么比较+后移赋值操作次数就会减少。
 *      希尔排序通过分组的办法让部分元素升序再进行整个序列排序。
 */
public class InsertSort {
    public static void sort(int[] nums){
        int length = nums.length;
        for(int i=1;i<length;i++){
            int temp = nums[i];
            int j=i;
            for(;j>0 && nums[j-1]>temp;j--){
                nums[j] = nums[j-1];
            }
            nums[j] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 5, 3, 4, 3 };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
