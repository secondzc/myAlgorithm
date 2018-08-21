package com.tongyuan.剑指offer;


import com.tongyuan.common.tree.Node;

/**
 * Created by zhangcy on 2018/7/25
 * 根据前序和中序重建（序列不包含重复数字）
 * 前序[3,8,9,2,4,7,5]
 * 中序[9,8,4,2,7,3,5]
 *
 * 输出后序序列,(边界问题不难）
 */

public class 重建二叉树 {


    public static Node rebuild(int[] front, int[] end, int start1, int end1, int start2, int end2){
        if(start1>end1){
            return null;
        }
        Node parent = new Node(front[start1]);
        int index = start2;
        while(index<=end2){
            if(end[index]==front[start1]){
                break;
            }
            index++;
        }
        Node left = rebuild(front,end,start1+1,index-start2+start1, start2,index-1);
        Node right = rebuild(front,end,index-start2+start1+1, end1,index+1,end2);
        parent.setLeft(left);
        parent.setRight(right);
        return parent;
    }

    public static void print(Node node){
        if(node!=null){
            if(node.getLeft()!=null){
                print(node.getLeft());
            }
            if(node.getRight()!=null){
                print(node.getRight());
            }
            System.out.print(node.getValue()+",");
        }else {
            return ;
        }
    }

    public static void main(String[] args) {
        Node root = rebuild(new int[]{3,8,9,2,4,7,5},new int[]{9,8,4,2,7,3,5},0,6,0,6);
        print(root);
    }

}
