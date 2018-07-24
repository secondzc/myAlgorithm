package com.tongyuan.sword;

/**
 * Created by zhangcy on 2018/7/22
 * 此题注意分段，以前看起来比较麻烦而已
 * 判断一个序列是不是二叉搜索树的后序遍历序列
 */
public class 二叉搜索树的后序遍历序列 {
    public static boolean isSequence(int[] nodes, int start, int end){
        //子序列为空或者为1的情况
        if(start==end || start-1==end){
            return true;
        }
        int root = nodes[end];
        int i = start;
        for (; i < end; i++) {
            if(nodes[i]>root){
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if(nodes[j]<root){
                return false;
            }
        }
        boolean left = isSequence(nodes,start,i-1);
        boolean right = isSequence(nodes,i,end-1);
        return left && right;
    }
    public static boolean isSequence(int[] nodes,int length){
        return isSequence(nodes,0,length-1);
    }

    public static void main(String[] args) {
        System.out.println(isSequence(new int[]{5,7,6,8,11,10,8},7));
        System.out.println(isSequence(new int[]{7,4,6,5},4));
    }

}
