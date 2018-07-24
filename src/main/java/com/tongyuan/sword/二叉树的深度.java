package com.tongyuan.sword;

import com.tongyuan.common.tree.TreeNode;

/**
 * Created by zhangcy on 2018/7/23
 */
public class 二叉树的深度 {
    public static int getDeepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDeepth = getDeepth(node.getLeft());
        int rightDeepth = getDeepth(node.getRight());
        return leftDeepth>rightDeepth?leftDeepth+1:rightDeepth+1;
    }
}
