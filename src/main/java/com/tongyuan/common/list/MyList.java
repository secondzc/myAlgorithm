package com.tongyuan.common.list;

/**
 * Created by zhangcy on 2018/7/21
 */
public class MyList {

    public static Node getList() {
        Node<Integer>[] nodes = new Node[5];
        for (int i = 0; i < 4; i++) {
            nodes[i].setValue(i);
            nodes[i].setNext(nodes[i+1]);
        }
        nodes[4].setValue(4);
        return nodes[0];
    }

    public static void main(String[] args) {
        Node<Integer> list = getList();
    }
}
