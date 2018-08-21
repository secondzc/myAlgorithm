package com.tongyuan.sort;

/**
 * Created by zhangcy on 2018/7/28
 * 从小到大排序
 * 步骤：1.将无序序列构成一个大顶堆（构造方法是从最后一个非叶子节点——下标为arr.length/2-1——开始从后往前调整，如果某个叶子节点不满足堆序特征，
 * 则要调整它的子树）
 * 2.每次将大顶堆第一个和最后一个互换，此时不一定满足堆序特征，需要重新调整堆结构
 * 3.反复进行，直到整个序列有序
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class 堆排序 {
}
