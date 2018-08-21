package com.tongyuan.剑指offer;


import com.tongyuan.common.tree.TreeNode;


/**
 * Created by zhangcy on 2018/7/23
 *
 * 注意：当递归调用时，如果参数是对象或者数组，在递归的深层对对象或者数组的修改会影响浅层，递归调用时，这些对象或者数组是
 * 引用传递，不会复制新值
 * 例外的是，如果参数是String类型，则比较安全，String类型是复制的一个新的对象
 *
 */
public class 打印字符串的排列 {
    // 联想到回溯算法，回溯是递归调用，然后修正成本来的状态，再循环
    // 交换之后，因为要循环所以要换回来
    // 同时，因为每一步都换回来了，所以递归不会改变chars的状态，是安全的
    public static void print(char[] chars, int index){
        if(index==chars.length-1){
            System.out.println(chars);
            return ;
        }
        for (int i = index; i < chars.length; i++) {
            char tmp = chars[index];
            chars[index] = chars[i];
            chars[i] = tmp;
            print(chars,index+1);
            tmp = chars[index];
            chars[index] = chars[i];
            chars[i] = tmp;
        }
    }


    public static void main(String[] args) {
        print("abc".toCharArray(),0);
        //test("000".toCharArray(),0);
        //test(new TreeNode(), 0 );
        //test("000",0);
    }

    public static void test(char[] chars,int i){
        if(i>=3){
            return ;
        }
        chars[i]='9';
        test(chars,i+1);
        System.out.println(chars);
    }
    public static void test(TreeNode node, int i){
        if(i==1){
            node.setValue("sssss");
            return ;
        }else{
            test(node,i+1);
            System.out.println(node.getValue());

        }
    }
    public static void test(String str,int i){
        if(i==1){
            str="ssss";
            return ;
        }else{
            test(str,i+1);
            System.out.println(str);
        }
    }


}
