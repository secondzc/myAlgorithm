package com.tongyuan.剑指offer;

import com.tongyuan.common.tree.MyTree;
import com.tongyuan.common.tree.TreeNode;

/**
 * Created by zhangcy on 2018/7/21
 * 非递归的实现
 */
public class 镜像二叉树 {
    public static void getReverse(TreeNode root, TreeNode root1){
        root1.setValue(root.getValue());
        if(root.getLeft() != null) {
            TreeNode right1 = new TreeNode();
            root1.setRight(right1);
            getReverse(root.getLeft(), right1);
        }
        if(root.getRight() != null) {
            TreeNode left1 = new TreeNode();
            root1.setLeft(left1);
            getReverse(root.getRight(), left1);
        }
    }
    public static TreeNode getReverse(TreeNode root){
        if(root == null) {
            return null;
        }
        TreeNode root1 = new TreeNode();
        getReverse(root,root1);
        return root1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = getReverse(MyTree.getTree());
        MyTree.printNode(treeNode);
    }
}
