package com.tongyuan.牛客;

import com.tongyuan.common.tree.MyTree;
import com.tongyuan.common.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by zhangcy on 2018/8/20
 *
 * https://blog.csdn.net/ryjflyshy/article/details/78250348
 * 三种方法都是用栈来实现的
 */
public class 非递归遍历二叉树 {
    //前序，
    //若不为空，则访问该节点并将右左节点放入栈中
    public static void travel1(TreeNode node){
        if(node==null){
            return ;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(node);
        while(!deque.isEmpty()){
            TreeNode treeNode = deque.pop();
            if(treeNode!=null){
                System.out.println(treeNode.getValue());
                deque.push(treeNode.getRight());
                deque.push(treeNode.getLeft());
            }
        }
    }

    //中序
    //把左子树入栈直到左子树为空，这时停止入栈，取出栈顶元素p并访问，访问结束后，判断p是否有右子树，若是，则将右子树赋值给p
    //如果不是，说明接下来访问的元素在栈顶，这时将p赋值为空，循环条件是p！=null || 栈不为空
    public static void travel2(TreeNode node){
        if(node==null){
            return ;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode p = node;
        while(p!=null || !deque.isEmpty()){
            while(p!=null){
                deque.push(p);
                p = p.getLeft();
            }
            p = deque.pop();
            System.out.println(p.getValue());
            if(p.getRight()==null){
                p = null;
            }else{
                p = p.getRight();
            }
        }
    }

    //后序
    //把左子树入栈直到左子树为空，这时停止入栈，取出栈顶元素p并访问，访问结束后，判断p是否是栈顶元素的左子树，若是，则将栈顶元素的
    //右子树取出并赋值给p，如果不是，则右子树访问完了，可以将p赋值为空，循环条件是p！=null || 栈不为空
    public static void travel3(TreeNode node){
        TreeNode p = node;
        Deque<TreeNode> deque = new LinkedList<>();
        while(p!=null || !deque.isEmpty()){
            while(p!=null){
                deque.push(p);
                p = p.getLeft();
            }
            p = deque.pop();
            System.out.println(p.getValue());
            if(!deque.isEmpty() && p==deque.peek().getLeft()){
                p=deque.peek().getRight();
            }else{
                p=null;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = MyTree.getTree();
        //travel1(node);
        //travel2(node);
        travel3(node);
    }
}
