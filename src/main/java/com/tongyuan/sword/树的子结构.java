package com.tongyuan.sword;

import com.tongyuan.common.tree.TreeNode;

/**
 * Created by zhangcy on 2018/7/21
 */
public class 树的子结构 {
    // 判断1是不是0的子结构
    public static boolean isSub(TreeNode root0, TreeNode root1) {

        if(root0 == null) {
            return false;
        }
        if(isSub1(root0,root1)){
            return true;
        }
        return isSub(root0.getLeft(),root1) || isSub(root0.getLeft(),root1);
    }

    // 若1是0的子结构且0和1的root节点相等 ，return true；
    public static boolean isSub1(TreeNode root0, TreeNode root1) {
        if(root1 != null){
            if(root0 == null) {
                return false;
            }
            if(!root1.getValue().equals(root0.getValue())) {
                return false;
            }
            return isSub1(root0.getLeft(),root1.getLeft()) && isSub1(root0.getRight(),root1.getRight());
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
