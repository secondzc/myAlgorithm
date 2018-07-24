package com.tongyuan.gragh.dataStruct;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangcy on 2018/3/5
 */
public class Vertex {
    private String name;
    private List<String> adj;
    public boolean visited;
    public int dist;
    public Vertex last;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return name.equals(vertex.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Vertex(String name, List<String> adj) {
        this.name = name;
        List<String> adj1 = new LinkedList<>();
        for(String s:adj){
            adj1.add(s);
        }
        this.adj = adj1;
    }

    public List<String> getAdj() {
        return adj;
    }

    public void setAdj(List adj) {
        this.adj = adj;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Vertex getLast() {
        return last;
    }

    public void setLast(Vertex last) {
        this.last = last;
    }
}
