package com.tongyuan.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcy on 2018/5/6
 * 网上的这个方法看起来比我自己写的要简洁
 * 主方法是private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn)
 */
public class Main06{
    //定义树节点
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        //如果起始下标大于结束下标，无效输入，终止程序
        if(startPre>endPre||startIn>endIn)
            return null;
        //前序遍历找到根节点
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){//i-startIn是左子树节点的个数，前序遍历起始值加上这个就是终点值
                //i-1就是中序遍历左子树的终点，起始值是从0一直从0开始
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                //前序右子树遍历的起始值:startPre+i-startIn+1 前序右子树遍历的终点值:endPre
                //中序遍历右子树的起始值:i+1,endIn
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }

        return root;
    }

    //中序遍历
    private List<Integer> listInorder=new ArrayList<Integer>() ;
    public void inOderPrint(TreeNode node){
        TreeNode temp=node;
        if(temp==null){throw new RuntimeException();
        }
        if(temp.left!=null){
            inOderPrint(temp.left);
        }
        listInorder.add(temp.val);
        if(temp.right!=null){
            inOderPrint(temp.right);
        }
    }

    private List<Integer> listPreorder=new ArrayList<Integer>() ;
    public void prePrint(TreeNode node){
        TreeNode temp=node;
        if(temp==null){
            throw  new RuntimeException();
        }
        listPreorder.add(temp.val);
        if(temp.left!=null){
            prePrint(temp.left);
        }if(temp.right!=null){
            prePrint(temp.right);
        }
    }

    public static void main(String[] args) {
        Main06 m=new Main06();
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        TreeNode node=m.reConstructBinaryTree(preOrder,inOrder);
        m.prePrint(node);
        m.inOderPrint(node);
        //m.print(m.listPreorder);
        //m.print(m.listInorder);
    }
}
