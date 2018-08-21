package com.tongyuan.剑指offer;

import com.tongyuan.common.tree.TreeNode;

/**
 * Created by zhangcy on 2018/7/23
 * 平衡二叉树的定义是：任一节点的左右子树的深度相差不超过1
 */
public class 二叉树是否为平衡的 {
    /*
    返回int[0] 表示深度
    int[1] 表示是否平衡，平衡为1，不平衡为0
     */

    public int[] getDeep(TreeNode node){
        if(node==null){
            return new int[]{0,1};
        }
        int[] left = getDeep(node.getLeft());
        int[] right = getDeep(node.getRight());
        if(left[1]==1 && right[1]==1){
            int leftDeep = left[0];
            int rightDeep = right[0];
            if(leftDeep-rightDeep>=-1 && leftDeep-rightDeep<=1){
                int deep = leftDeep>rightDeep?leftDeep+1:rightDeep+1;
                return new int[]{deep,1};
            }else{
                return new int[]{0,0};
            }
        }else {
            return new int[]{0,0};
        }
    }
    public boolean isBalanced(TreeNode root){
        return getDeep(root)[1]==1?true:false;
    }
}
