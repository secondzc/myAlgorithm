package com.tongyuan.collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangcy on 2018/1/26
 */
public class TestDeque {
    public static void main(String[] args) {
        Queue<Integer> queue  = new LinkedList<Integer>();
        System.out.println("queue usage");
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue);
        System.out.println(queue.peek());
        //当queue用于当队列用时，和queue完全等效offer = offerLast，peek = peekFirst
        System.out.println("deque as queue");
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);
        deque.offerLast(2);
        System.out.println(deque);
        System.out.println(deque.peekFirst());
        deque.pollFirst();
        System.out.println(deque);
        //当queue用作栈时
        System.out.println("deque as stack");
        deque.clear();
        deque.offerFirst(1);
        deque.offerFirst(2);
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());
    }
}
