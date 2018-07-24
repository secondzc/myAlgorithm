package com.tongyuan.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangcy on 2018/5/6
 * 后序遍历一颗树
 */
public class PostOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        PostOrder p = new PostOrder();
        TreeNode node1 = p.new TreeNode(1);
        TreeNode node2 = p.new TreeNode(2);
        TreeNode node3 = p.new TreeNode(3);
        TreeNode node4 = p.new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        //print1(node1);
        preNot(node1);
    }

    public static void print1(TreeNode root){
        if(root.left!=null){
            print1(root.left);
        }
        if(root.right!=null){
            print1(root.right);
        }
        System.out.print(root.val);
    }

    //用非递归方法完成的后序遍历
    //用两个栈来实现的，感觉换来换去的挺复杂的，比非递归完成前序遍历只用一个栈要难。以下两个函数是网上copy的，还需理解
    public static void postNot(TreeNode head) {
        Stack<TreeNode> storeStack = new Stack<TreeNode>();
        Stack<TreeNode> popStack = new Stack<TreeNode>();
        if (head != null) {
            storeStack.push(head);
            while(!storeStack.isEmpty()) {
                head = storeStack.pop();
                popStack.push(head);
                if (head.left != null) {
                    storeStack.push(head.left);
                }
                if (head.right != null) {
                    storeStack.push(head.right);
                }
            }
        } else {
            System.out.println("Tree is no data");
        }
        while (!popStack.isEmpty()) {
            System.out.print(popStack.pop().val + "\t");
        }
    }

    //非递归方法完成前序遍历
    //一般递归->非递归的思路是，都是有一个变量，有一个循环，来代替递归
    //这里这个变量就是Node，思考：遍历是一个子树处理完了再处理另外一个子树，有栈的特征，所以有一个Stack
    public static void preNot(TreeNode root){
        if(root!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val);
                if(root.right!=null){
                    stack.push(root.right);
                }
                if(root.left!=null){
                    stack.push(root.left);
                }
            }
        }
    }

}
