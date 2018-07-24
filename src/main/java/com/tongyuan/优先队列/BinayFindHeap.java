package com.tongyuan.优先队列;

/**
 * Created by zhangcy on 2018/3/5
 * 二叉查找树实现的优先队列(太麻烦且没有速度优势，不推荐使用，只是练习一下）
 * 严格的二叉查找树 树中元素不重复，这里为了实现可以有重复元素的优先队列做一点小改变，定义
 * 左子树中的元素<=根节点元素，右子树中的元素> 根节点元素
 *
 */
public class BinayFindHeap<T extends Comparable> implements PriorityQueue<T> {

    class Node{
        Comparable value;
        Node left;
        Node right;

        public Node(Comparable value) {
            this.value = value;
        }

        public Node() {
        }
    }


    //二叉查找树
    private Node root = new Node();

    @Override
    public T deleteMin() {
        return del(root,null);
    }

    /*
    对以node为根的树进行删除操作, parent为node的父节点
    这里想了好久：因为这里定义的Node数据结构不含有父节点的指针，所以删除节点node时怎么在树中删除它成了一个问题（不能直接写node=null，因为这里是一个递归调用）
    所以在参数中加入一个parent记录node的父节点
     */
    private T del(Node node,Node parent){
        if(node == null){
            return null;
        }
        if(node.left != null){
            return del(node.left,node);
        }
        //若左子节点为null，node！=null，则删除node本身
        T tmp = (T) node.value;
        if(parent != null){
            //在树中删除节点  1.此node只可能是parent的左子节点，因为若是右子节点，父节点早已删除了 2.此node不可能有左子节点了，若此node有右子节点，
            // 则parent.left = node.right
            if(node.right != null){
                parent.left = node.right;
            }else {
                parent.left = null;
            }
        }else{//parent为空，这是node = root，若右节点存在则需要重置root为右节点
            if(node.right != null){
                this.root = node.right;
            }
        }
        return tmp;
    }

    @Override
    public void insert(T ele) {
        insert(ele,root);
    }

    private void insert(T ele,Node node){
        if(node.value == null){
            node.value = ele;
        }else {
            if(ele.compareTo(node.value)>0){
                if(node.right == null){
                    node.right = new Node();
                }
                insert(ele,node.right);
            }else{
                if(node.left == null){
                    node.left = new Node();
                }
                insert(ele,node.left);
            }
        }
    }

    public static void main(String[] args) {
        BinayFindHeap<Integer> binayFindHeap = new BinayFindHeap<>();
        binayFindHeap.insert(1);
        binayFindHeap.insert(1);
        binayFindHeap.insert(4);
        binayFindHeap.insert(1);
        binayFindHeap.insert(2);
        binayFindHeap.insert(4);
        binayFindHeap.insert(5);
        for(int i=0;i<7;i++){
            System.out.println(binayFindHeap.deleteMin());
        }
    }

}
