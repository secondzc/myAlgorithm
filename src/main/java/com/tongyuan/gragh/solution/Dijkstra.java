package com.tongyuan.gragh.solution;



import com.tongyuan.gragh.dataStruct.Gragh;
import com.tongyuan.gragh.dataStruct.Vertex;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangcy on 2018/3/5
 * 适合密集的图
 * 若是稀疏的图，则notVisted（）方法这种逐个定点扫描寻找notVisted顶点的方法就慢了一点，要用优先队列。
 */
public class Dijkstra {
    private Gragh gragh;

    public List<Vertex> notVisted(){
        List<Vertex> notVisted = new LinkedList<>();
        for(Vertex vertex:gragh.getVertices()){
            if(vertex.isVisited()){
                notVisted.add(vertex);
            }
        }
        return notVisted;
    }
    public void execute(Vertex vertex){
        for(Vertex vertex1:gragh.getVertices()){
            vertex1.setDist(Integer.MAX_VALUE);
            vertex1.setVisited(false);
        }
        vertex.setDist(0);
        List<Vertex> notVisted = notVisted();
        while(!notVisted.isEmpty()){
            Vertex smallestVertex = notVisted.get(0);
            for(Vertex v: notVisted){
                if(v.getDist()<smallestVertex.getDist()){
                    smallestVertex = v;
                }
            }
            smallestVertex.setVisited(true);
            for(String adj:vertex.getAdj()){
                Vertex adjVertex = gragh.name2Vertex(adj);
                if(!adjVertex.isVisited()){
                    Integer csa = getCost(smallestVertex,adjVertex);
                    if(smallestVertex.getDist()+csa<adjVertex.getDist()){
                        //更新
                        adjVertex.setDist(smallestVertex.getDist()+csa);
                        adjVertex.setLast(smallestVertex);
                    }
                }
            }
        }
    }

    public Integer getCost(Vertex from ,Vertex to){
        // TODO: 2018/3/5
        return null;
    }

}
