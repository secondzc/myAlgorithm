package com.tongyuan.tree;

import java.util.HashMap;

/**
 * Created by zhangcy on 2018/1/19
 * 根据前序和中序构建树，并输出后序的序列
 */
public class FrontSequence {
    class Node{
         char c;
         Node left;
         Node right;
         Node parent;
         Node(char _c){
             c = _c;
         }
         public String toString(){
             return String.valueOf(c);
         }
    }

    //从根节点出发找左子节点，若找到a下面没有左子节点了，找其右子节点，找不到了为止
    //note:这个方法对重建树是没有意义的
    public Node findEntrance(Node root){
        //默认root是不为空的
        if(root.left!=null){
            return findEntrance(root.left);
        }else if(root.right!=null){
            return findEntrance(root.right);
        }else{
            return root;
        }
    }

    private StringBuilder sb = null;
    //传入根节点，打印后序序列,参数不为空
    //为什么这里只有一句sb.append  思维过程是：按照后序遍历一次树，并在遍历的过程中将c加入到sb，一次traverse就是一个节点的遍历，所以打印一次
    public void traverse(Node root){
        if(root.left!=null){
            traverse(root.left);
        }
        if(root.right!=null){
            traverse(root.right);
        }
        sb.append(root.c);
    }
    //打印整棵树
    public void print(Node root){
        sb = new StringBuilder();
        traverse(root);
        System.out.println(sb);
    }


    //返回构建子树的root
    //默认输入是不会出现重复字符的
    public Node recurBuild(String front,String mid){
        if("".equals(front)){
            return null;
        }
        char firstChar = front.charAt(0);
        //前序的首字母在中序中出现的index
        Integer firstCharIndex = mid.indexOf(firstChar);
        Node root = new Node(firstChar);
        String part1 = mid.substring(0,firstCharIndex);
        String part2 = mid.substring(firstCharIndex+1);
        //从前序中进行分离
        int partPos = 1;
        while((partPos<front.length()) && mid.indexOf(front.charAt(partPos))<firstCharIndex){
            partPos++;
        }
        String front1 = front.substring(1,partPos);
        String front2 = front.substring(partPos);
        String mid1 = mid.substring(0,firstCharIndex);
        String mid2 = mid.substring(firstCharIndex+1);
        Node leftNode = recurBuild(front1,mid1);
        Node rightNode = recurBuild(front2,mid2);
        root.left = leftNode;
        root.right = rightNode;
        if(leftNode!=null){
            leftNode.parent = root;
        }
        if(rightNode!=null){
            rightNode.parent = root;
        }
        return root;
    }


    public static void main(String[] args) {
        FrontSequence fs = new FrontSequence();
        Node root = fs.recurBuild("ABDEFC","DBFEAC");
        fs.print(root);
        System.out.println(fs.findEntrance(root));
    }
}
