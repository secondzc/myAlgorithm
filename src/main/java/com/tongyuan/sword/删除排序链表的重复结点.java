package com.tongyuan.sword;

import com.tongyuan.common.list.MyList;
import com.tongyuan.common.list.Node;

/**
 * Created by zhangcy on 2018/7/24
 *
 * 1.需要两个指针，一个指向前一个节点preNode，另一个指向当前节点node，如果遇到相等的节点，node向后
 * 移动，preNode不动，存下node.val方便后面的比较，直到遇到node和node.next不相等，preNode就可以指向node.next
 * 2. 注意：链表开头可能就开始有重复的节点，所以默认preNode=null，在后面的给preNode赋值的时候，
 * 若preNode为null，那就把pHead设置为node.next
 */
public class 删除排序链表的重复结点 {
    public static Node deletRepeat(Node head){
        Node pre = null;
        Node node = head;
        while(node!=null){
            if(node.getNext()!=null && node.getNext().getValue()==node.getValue()){
                //如果node和下个节点相同
                Comparable value = node.getValue();
                while(node.getNext()!=null && node.getNext().getValue()==value){
                    node = node.getNext();
                }
                //接下来删去相同的结点(这时要么node下个结点为空，或者node的下个结点和node不同）
                if(pre!=null){
                    pre.setNext(node.getNext());
                }else{
                    //若pre本来就没有初始化，则忽略
                    head = node.getNext();
                }
            }else{//若node的下个结点为空，或者node的下个结点和node不同
                pre = node;
            }
            node = node.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = MyList.array2List(new int[]{1,2,3,3,4,4,5});
        Node head1 = deletRepeat(head);
        System.out.println(head1);
    }
}
