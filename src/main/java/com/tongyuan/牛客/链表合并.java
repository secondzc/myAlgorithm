package com.tongyuan.牛客;

import com.tongyuan.common.list.MyList;
import com.tongyuan.common.list.Node;

/**
 * Created by zhangcy on 2018/8/9
 */
public class 链表合并 {
    public static Node merge(Node a,Node b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        Node i = a;
        Node j = b;
        Node k = null;
        Node phead = null;
        while(i!=null && j!=null){
            Node node = null;
            if(i.getValue().compareTo(j.getValue())>0){
                node = new Node(j.getValue());
                j = j.getNext();
            }else{
                node = new Node(i.getValue());
                i = i.getNext();
            }
            if(k==null){
                k=node;
                phead = node;
            }else{
                k.setNext(node);
                k=node;
            }
        }
        Node cur = null;
        if(i!=null){
           cur=i;
        }else{
            cur = j;
        }
        while(cur!=null){
            Node node = new Node(cur.getValue());
            if(k==null){
                k=node;
                phead = node;
            }else{
                k.setNext(node);
                k=node;
            }
            cur = cur.getNext();
        }
        return phead;
    }

    public static void main(String[] args) {
        Node node1 = MyList.array2List(new int[]{1,3,5});
        Node node2 = MyList.array2List(new int[]{2,4,7,8});
        Node node3 = merge(node1,node2);
        System.out.println(node3);
    }
}
