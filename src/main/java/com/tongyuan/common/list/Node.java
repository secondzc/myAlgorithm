package com.tongyuan.common.list;

import java.io.Serializable;

/**
 * Created by zhangcy on 2018/7/17
 */
public class Node<T> {
    Comparable<T> value;
    Node next;

    public Comparable<T> getValue() {
        return value;
    }

    public void setValue(Comparable value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Comparable<T> value) {
        this.value = value;
    }

    public Node() {
    }
}
