package com.tongyuan.sword;

import com.tongyuan.common.list.MyList;
import com.tongyuan.common.list.Node;

/**
 * Created by zhangcy on 2018/7/17
 */
public class 反转list {

    //方法一：递归
    public static void reverse1(Node node) {
        if(node == null) {
            return ;
        }
        Node next = node.getNext();
        reverse1(next);
        node.setNext(null);
        if(next != null) {
            next.setNext(node);
        }
    }

    //方法二：非递归
    public static void reverse2(Node node) {
        Node last = null;
        while(node!=null) {
            Node next = node.getNext();
            Node nextnext = null;
            node.setNext(last);
            if (next != null) {
                nextnext = next.getNext();
                next.setNext(node);
            }
            last = node;
            node = nextnext;
        }
    }

    public static void main(String[] args) {
        Node node = MyList.array2List(new int[]{1,2,3});
        reverse1(node);
        System.out.println(node);
    }
}
