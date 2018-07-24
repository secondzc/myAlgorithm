package com.tongyuan.common.list;

/**
 * Created by zhangcy on 2018/7/21
 */
public class MyList {

    public static Node array2List(Integer[] arr){
        if(arr.length<1){
            return null;
        }
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node();
            node.setValue(arr[i]);
            tail.setNext(node);
            tail = node;
        }
        return head;
    }

}
