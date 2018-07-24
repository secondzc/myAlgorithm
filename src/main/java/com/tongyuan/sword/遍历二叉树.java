package com.tongyuan.sword;

import com.tongyuan.common.tree.MyTree;
import com.tongyuan.common.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangcy on 2018/7/21
 */
public class 遍历二叉树 {
    // 广度优先，非递归，用到队列
    public static void print(TreeNode root) {
        if(root == null){
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.getValue());
            if(treeNode.getLeft() != null){
                queue.offer(treeNode.getLeft());
            }
            if(treeNode.getRight() != null){
                queue.offer(treeNode.getRight());
            }
        }
    }

    // 递归，深度优先，简单

    // 非递归，深度优先，用到栈
    public static void print1(TreeNode root) {
        if(root == null) {
            return ;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        while(!deque.isEmpty()){
            TreeNode treeNode = deque.pollFirst();
            System.out.println(treeNode.getValue());
            if(treeNode.getRight() != null){
                deque.offerFirst(treeNode.getRight());
            }
            if(treeNode.getLeft() != null){
                deque.offerFirst(treeNode.getLeft());
            }

        }
    }

    // 递归，后序遍历
    public static void print2(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.getLeft() != null){
            print2(root.getLeft());
        }
        if(root.getRight() != null){
            print2(root.getRight());
        }
        System.out.println(root.getValue());
    }


    public static void main(String[] args) {
        print2(MyTree.getTree());
    }
}
