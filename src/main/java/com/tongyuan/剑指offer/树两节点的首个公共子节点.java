package com.tongyuan.剑指offer;

import com.tongyuan.common.tree.MyTree;
import com.tongyuan.common.tree.TreeNode;
import javafx.util.Pair;

/**
 * Created by zhangcy on 2018/7/23
 *
 */
public class 树两节点的首个公共子节点 {
    /**
     * 若是排序二叉树
     * 设node1<node2
     * 从root节点开始，若node大于node1和node2，则找node的左子树，若node小于node1和node2，则找node的右子树
     * 若node大于node1小于node2，则node就是要找的首个公共子节点
     */

    /**
     * 若含有指向父节点的指针，则转换成链表求公共节点
     */

    /**
     * 若没有含有指向父节点的指针,
     * 1.可以遍历找到这两个子节点并记录这两个子节点的路径，根据这个路径用两个指针即可（不需要像链表公共节点那么麻烦，因为这里是从root节点开始的）
     * 2.可以后序遍历，如下
     */
    public static Pair<Integer,TreeNode> containsTimes(TreeNode root, TreeNode node1, TreeNode node2){
        if(root==null){
            return new Pair<>(0,null);
        }
        int leftTimes=0;
        int rightTimes=0;
        if(root.getLeft()!=null){
            Pair<Integer,TreeNode> pair = containsTimes(root.getLeft(),node1,node2);
            leftTimes = pair.getKey();
            if(leftTimes==2){
                return pair;
            }
        }
        if(root.getRight()!=null){
            Pair<Integer,TreeNode> pair = containsTimes(root.getRight(),node1,node2);
            rightTimes = pair.getKey();
            if(rightTimes==2){
                return pair;
            }
        }
        int times = 0;
        if(root==node1 || root==node2){
            times = leftTimes+rightTimes+1;
        }else{
            times = leftTimes+rightTimes;
        }
        if(times==2){
            return new Pair<>(2,root);
        }else{
            return new Pair<>(times,null);
        }
    }

    public static void main(String[] args) {
        TreeNode root = MyTree.getTree();
        Pair<Integer,TreeNode> pair = containsTimes(root,MyTree.get4(),MyTree.get9());
        System.out.println(pair.getKey());
        System.out.println(pair.getValue().getValue());
    }
}
