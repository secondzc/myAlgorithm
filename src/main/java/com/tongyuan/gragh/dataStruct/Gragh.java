package com.tongyuan.gragh.dataStruct;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangcy on 2018/3/5
 */
public class Gragh {
    private LinkedList<Vertex> vertices;

    public LinkedList<Vertex> getVertices() {
        return vertices;
    }

    public Gragh(LinkedList<Vertex> vertices) {
        LinkedList<Vertex> vertices1 = new LinkedList<>();
        for(Vertex vertex:vertices){
            vertices1.add(new Vertex(vertex.getName(),vertex.getAdj()));
        }
        this.vertices = vertices1;
    }

    public List<Vertex> name2Vertex(List<String> names){
        List<Vertex> vertices1 = new LinkedList<>();
        for(String name:names){
            vertices1.add(name2Vertex(name));
        }
        return vertices1;
    }

    public Vertex name2Vertex(String name){
        for(Vertex v:vertices){
            if(v.getName().equals(name)){
                return v;
            }
        }
        return null;
    }
}
