package com.tongyuan.优先队列;

/**
 * Created by zhangcy on 2018/3/5
 */
public interface PriorityQueue<T extends Comparable> {
    T deleteMin();
    void insert(T ele);
}
