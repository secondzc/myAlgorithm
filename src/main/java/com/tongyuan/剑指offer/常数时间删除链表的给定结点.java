package com.tongyuan.剑指offer;

import com.tongyuan.common.list.Node;

/**
 * Created by zhangcy on 2018/7/25
 * 若下个节点不为空，将下个节点复制到本节点，并删除下个节点
 * 若下个节点为空，则直接将本节点置为空
 * 确保node不为空，且在链表中
 */
public class 常数时间删除链表的给定结点 {
    public static void delete(Node node){
        Node next = node.getNext();
        if(next != null){
            node.setValue(next.getValue());
            node.setNext(next.getNext());
            next.setNext(null);
        }else{
            node = null;
        }
    }
}
