package com.tongyuan.common.tree;

/**
 * Created by zhangcy on 2018/7/21
 *
 * 构造如下的一颗树
 *         8
 *        / \
 *       8   7
 *      / |
 *     9  2
 *       / |
 *      4  7
 */
public class MyTree {
    static TreeNode[] treeNodes;
    static {
         treeNodes = new TreeNode[7];
        for (int i = 0; i < 7; i++) {
            treeNodes[i] = new TreeNode();
        }
        treeNodes[0].setValue("8");
        treeNodes[0].setLeft(treeNodes[1]);
        treeNodes[0].setRight(treeNodes[2]);

        treeNodes[1].setValue("8");
        treeNodes[1].setLeft(treeNodes[3]);
        treeNodes[1].setRight(treeNodes[4]);

        treeNodes[2].setValue("7");

        treeNodes[3].setValue("9");

        treeNodes[4].setValue("2");
        treeNodes[4].setLeft(treeNodes[5]);
        treeNodes[4].setRight(treeNodes[6]);

        treeNodes[5].setValue("4");

        treeNodes[6].setValue("7");
    }

    public static TreeNode getTree() {
        return treeNodes[0];
    }
    public static TreeNode get9(){
        return getTree().getLeft().getLeft();
    }
    public static TreeNode get4(){
        return getTree().getLeft().getRight().getLeft();
    }


    public static void printNode(TreeNode treeNode) {
        if(treeNode == null){
            return ;
        }
        System.out.print("value=" + treeNode.getValue());
        if (treeNode.getLeft() != null) {
            System.out.print(" left=" + treeNode.getLeft().getValue());
        }
        if(treeNode.getRight() != null) {
            System.out.print(" right=" + treeNode.getRight().getValue());
        }
        System.out.println();
        printNode(treeNode.getLeft());
        printNode(treeNode.getRight());
    }

}
