package com.tongyuan.优先队列;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zhangcy on 2018/3/5
 * 完全二叉树实现的优先队列
 */
public class BinayCompleteHeap<T extends Comparable> implements PriorityQueue<T> {

    T[] elements = (T[]) new Comparable[8];
    Integer currentSize = 0;

    private void checkAndEnlarge(){
        if(currentSize==elements.length-1){
            elements = Arrays.copyOf(elements,currentSize*2+1);
        }
    }

    /*
    删除+下滤，因为要保持父节点小于其两个子节点，所以用child来记录子节点中的较小值
     */
    @Override
    public T deleteMin() {
        T min = elements[1];
        if(currentSize == 3){
            elements[1] = (elements[2].compareTo(elements[3])>0)?elements[3]:elements[2];
            elements[2] = (elements[2].compareTo(elements[3])<=0)?elements[3]:elements[2];
            return min;
        }
        currentSize--;
        Integer hole = 1;
        Integer child = -1;
        while((hole*2+1)<=currentSize){
            child = hole*2;
            if(child != currentSize && (elements[child].compareTo(elements[child+1])>0)){
                child = child+1;
            }
            //比较较小的子节点和elements[currentSize]
            if(elements[child].compareTo(elements[currentSize+1])>0){
                break;
            }else{
                elements[hole] = elements[child];
                hole = child;
            }
        }
        elements[hole] = elements[currentSize+1];
        elements[currentSize+1]=null;
        return min;
    }

    @Override
    public void insert(T ele) {
        //扩容
        checkAndEnlarge();
        Integer hole = ++currentSize;
        while(hole != 1 && elements[hole/2].compareTo(ele)>0){
            elements[hole] = elements[hole/2];
            hole/=2;
        }
        elements[hole] = ele;
    }

    public void buildHeap(T[] elements){
        for(int i=0;i<elements.length;i++){
            insert(elements[i]);
        }
    }

    public void print(){
        for(int i=0;i<elements.length;i++){
            System.out.println(elements[i]);
        }
    }

    public static void main(String[] args) {
        BinayCompleteHeap binayCompleteHeap = new BinayCompleteHeap();
        binayCompleteHeap.buildHeap(new Integer[]{16,19,13,14,21,19,68,65,26,32,31});
        binayCompleteHeap.print();
        System.out.println("======");
        for(int i=0;i<11;i++){
            Integer del = (Integer) binayCompleteHeap.deleteMin();
            System.out.println(del);
        }
    }
}
