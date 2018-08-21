package com.tongyuan.剑指offer;

import com.tongyuan.common.tree.MyTree;
import com.tongyuan.common.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangcy on 2018/7/24
 * 这题除了计数的方法，还可以用两个队列来完成
 * 这题也可以用来解决按照之字形打印二叉树，就是把偶数行数放进栈中，再依次打印出来
 * 之字形打印二叉树还有一个解决办法是用两个栈，奇数层从左到右存入栈1，偶数层从右到左存入栈2
 */
public class 把二叉树打印成多行 {
    public static void print(TreeNode root){
        if(root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int count =1;
            while(!queue.isEmpty()){
                int nextCount = 0;
                while(count>0){
                    TreeNode node = queue.poll();
                    if(node.getLeft()!=null){
                        queue.offer(node.getLeft());
                        nextCount++;
                    }
                    if(node.getRight()!=null){
                        queue.offer(node.getRight());
                        nextCount++;
                    }
                    System.out.print(node.getValue());
                    count--;
                }
                System.out.println();
                count=nextCount;
            }
        }
    }

    public static void main(String[] args) {
        print(MyTree.getTree());
    }
}
