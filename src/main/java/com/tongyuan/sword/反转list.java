package com.tongyuan.sword;

import com.tongyuan.common.list.Node;

/**
 * Created by zhangcy on 2018/7/17
 */
public class 反转list {

//    方法一：递归
//    public static void reverse(TreeNode node) {
//        if(node == null) {
//            return ;
//        }
//        TreeNode next = node.getNext();
//        reverse(next);
//        node.setNext(null);
//        if(next != null) {
//            next.setNext(node);
//        }
//    }

    //方法二：非递归
    public static void reverse(Node node) {
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
        Node node0 = new Node();
        node0.setValue(0);
        Node node1 = new Node();
        node1.setValue(1);
        node0.setNext(node1);
        reverse(node0);
        System.out.println(1);
    }
}
