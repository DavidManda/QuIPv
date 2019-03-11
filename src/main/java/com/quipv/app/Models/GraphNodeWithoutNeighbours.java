package com.quipv.app.Models;

public class GraphNodeWithoutNeighbours {
    private String name;
    private int count;
    private int index;
    private boolean isDriver;

    public GraphNodeWithoutNeighbours(GraphNode node){
        this.name = node.getName();
        this.count = node.getCount();
        this.index = node.getIndex();
        this.isDriver = node.isDriver();
    }

    public boolean isDriver() {
        return isDriver;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }
}
