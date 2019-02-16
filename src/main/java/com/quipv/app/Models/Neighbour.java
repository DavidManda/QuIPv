package com.quipv.app.Models;

public class Neighbour {
    public GraphNode node;
    public Integer weight;

    public Neighbour(GraphNode node, Integer weight){
        this.node = node;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o){

        return this.node.equals(o);
    }

    @Override
    public int hashCode() {
        return this.node.hashCode();
    }

    public String toString(){
        return this.node.toString();
    }
}
