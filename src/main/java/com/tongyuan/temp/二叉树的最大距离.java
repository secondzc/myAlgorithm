package com.tongyuan.temp;

import com.tongyuan.common.tree.TreeNode;

/**
 * Created by zhangcy on 2018/8/16
 */
public class 二叉树的最大距离 {
    public static int maxLen(TreeNode node,Result result){
        if(node==null){
            return 0;
        }
        Result left = new Result();
        Result right = new Result();
        maxLen(node.getLeft(),left);
        maxLen(node.getRight(),right);
        result.maxDepth = Math.max(left.maxDepth,right.maxDepth);
        //左子树的最大长度 右子树的最大长度 左右子树最大深度之和+1
        result.maxLenth = Math.max(Math.max(left.maxLenth,right.maxLenth),left.maxDepth+right.maxDepth+1);
        return result.maxLenth;
    }
    public static class Result{
        private int maxDepth=0;
        private int maxLenth=0;
    }
}
