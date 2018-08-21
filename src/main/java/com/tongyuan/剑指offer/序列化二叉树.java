package com.tongyuan.剑指offer;

import com.tongyuan.common.tree.MyTree;
import com.tongyuan.common.tree.TreeNode;

/**
 * Created by zhangcy on 2018/7/24
 */
public class 序列化二叉树 {
    public static String serialize(TreeNode root){
        if(root==null){
            return "#";
        }
        StringBuilder sb = new StringBuilder(root.getValue());
        return sb.append(",").append(serialize(root.getLeft())).append(",").append(serialize(root.getRight())).toString();
    }

    public static void main(String[] args) {
        System.out.println(serialize(MyTree.getTree()));
    }
}
