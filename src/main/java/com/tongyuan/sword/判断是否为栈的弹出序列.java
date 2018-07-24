package com.tongyuan.sword;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhangcy on 2018/7/22
 * 用一个辅助栈，比如压入序列为1，2，3，4，5
 * 弹出序列为4，5，3，2，1
 *
 * 1.比较弹出序列的第i个元素a和辅助栈的栈顶，若相等则弹出辅助栈栈顶元素，若不相等，按照压入序列将元素压入辅助栈中，直到a
 * 2.如果到弹出序列的某个元素a时，既和辅助栈栈顶不等，由不能从压入序列中压入a，则这个弹出序列是错误的
 * 3.最后判断条件是这个辅助栈是否为空
 */
public class 判断是否为栈的弹出序列 {
    public static boolean isSequence(int[] push,int[] pop,int length){
        Deque<Integer> deque = new LinkedList<>();
        int j =0;
        for (int i = 0; i <length ; i++) {
            if(!deque.isEmpty()){
                if(deque.peekFirst().equals(pop[i])){
                    deque.pollFirst();
                    continue;
                }
            }
            for (; j < length; j++) {
                deque.offerFirst(push[j]);
                if(push[j] == pop[i]){
                    j++;
                    deque.pollFirst();
                    break;
                }
            }
        }
        if(deque.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop1 = new int[]{4,5,3,2,1};
        int[] pop2 = new int[]{4,3,5,1,2};
        System.out.println(isSequence(push,pop1,5));
        System.out.println(isSequence(push,pop2,5));
    }
}
