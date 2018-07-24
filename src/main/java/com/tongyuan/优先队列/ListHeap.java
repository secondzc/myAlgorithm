package com.tongyuan.优先队列;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by zhangcy on 2018/3/5
 * 用每次插入都维持顺序的链表实现
 * 从first到last按照从小到大排列
 */
public class ListHeap<T extends Comparable> implements PriorityQueue<T> {
    private LinkedList<T> list;

    @Override
    public T deleteMin() {
        return list.pollFirst();
    }

    @Override
    public void insert(T ele) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(ele) < 0) {
                i++;
            } else {
                list.add(i, ele);
            }
        }
    }
}
