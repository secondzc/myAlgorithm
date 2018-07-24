package com.tongyuan.gragh;

import java.util.*;

/**
 * Created by zhangcy on 2018/1/21
 * 近似图着色算法（多项式时间）
 *
 */
public class SetColor {
    private Integer[][] gragh;
    //key为node下标，value为分配的寄存器
    Map<Integer,String> map;

    public static class Node implements Comparable<Node>{
        //例如 1，3，4，2表示本节点不能着色1，3，4，
        String notColor;
        //最后选择了2进行着色
        String useColor;
        Integer degree;
        Integer index;
        Node(Integer _index,Integer _degree,String _notColor,String _useColor){
            degree = _degree;
            index = _index;
            notColor = _notColor;
            useColor = _useColor;
        }

        @Override
        public int compareTo(Node o) {
            return this.degree<o.degree? -1:(this.degree==o.degree ? 0: 1);
        }
    }

    public void setGragh(Integer[][] gragh,int n){
        this.gragh = new Integer[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                this.gragh[i][j] = gragh[i][j];
            }
        }
    }

    //创建节点list
    public List<Node> buildList(){
        List<Node> l = new ArrayList();
        int count=0;
        for(int i=0;i<gragh.length;i++){
            count = 0;
            for(int j=0;j<gragh.length;j++){
                if(gragh[i][j].equals(1)){
                    count++;
                }
            }
            l.add(new Node(i,count,"",""));
        }
        return l;
    }

    //选出list中度最大的node
    public Node maxDegree(List<Node> nodes){
        int max=0;
        Node maxNode = null;
        for(Node n:nodes){
            if(n.degree>max){
                max=n.degree;
                maxNode = n;
            }
        }
        return maxNode;
    }

    //更新nodes,包括更新与这一节点有关的节点的度数和不可用颜色，返回更新后排除了选择node的list
    public List<Node> fresh(List<Node> nodes,Node excludeNode){
        for(int i=0;i<gragh.length;i++){
            if(gragh[i][excludeNode.index]==1){
                for(Node n:nodes){
                    //若和删除的节点有边，则找到对应node，做处理
                    if(n.index==i){
                        n.degree--;
                        n.notColor = n.notColor+excludeNode.useColor+",";
                    }
                }
            }
        }
        nodes.remove(excludeNode);
        return nodes;
    }

    //对所选择的node分配寄存器, 还要设置与它相邻的node排除这个寄存器
    public void distribute(Node node){
        if("".equals(node.notColor)){
            node.useColor = "1";
        }else{
            String[] notColors = node.notColor.split(",");
            int i=0;
            while(i<notColors.length && Integer.valueOf(notColors[i])==i+1){
                i++;
            }
            node.useColor = String.valueOf(i+1);
        }
        if(map==null){
            map = new LinkedHashMap<Integer,String>();
        }
        map.put(node.index,node.useColor);
    }

    //主方法
    public void handle(Integer[][] gragh,int n){
        setGragh(gragh,n);
        List<Node> nodes = buildList();
        while(!nodes.isEmpty()){
            Node selectedNode = maxDegree(nodes);
            distribute(selectedNode);
            nodes = fresh(nodes,selectedNode);
        }
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println("node下标+1："+(entry.getKey()+1)+"   分配的寄存器："+entry.getValue());
        }
    }


    public static void main(String[] args) {
        Integer[][] gragh = {
                {1,1,0,1,0,1},
                {1,1,0,1,0,1},
                {0,0,1,1,1,1},
                {1,1,1,1,0,1},
                {0,0,1,0,1,1},
                {1,1,1,1,1,1},
        };
        SetColor s = new SetColor();
        s.handle(gragh,6);

    }
}
