package com.tongyuan.sort;

/**
 * Created by zhangcy on 2018/4/1
 * 归并排序
 * 原理:将序列分割为两个子序列,再对两个子序列采用归并排序，最后将排序好的子序列合并成最终序列。
 * 时间复杂度:O(NlogN)
 * 空间复杂度:O(N)
 * 稳定性:稳定
 * 优化:
 *  1.对于小序列直接使用选择排序;
 *  2.合并前判断nums[mid]是否小于等于nums[mid+1]
 *  3.为了节省数组拷贝的时间，可以在递归调用的每层交换初始数组和辅助数组。
 */
public class MergeSort {
}
