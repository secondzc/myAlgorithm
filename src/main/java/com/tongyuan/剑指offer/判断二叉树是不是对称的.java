package com.tongyuan.剑指offer;

import com.tongyuan.common.tree.TreeNode;

/**
 * Created by zhangcy on 2018/7/24
 */
public class 判断二叉树是不是对称的 {
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        if(!left.getValue().equals(right.getValue())){
            return false;
        }else{
            return isSymmetric(left.getLeft(),right.getRight()) && isSymmetric(left.getRight(),right.getLeft());
        }
    }
    public boolean isSymmetirc(TreeNode root){
        return isSymmetric(root,root);
    }

}
