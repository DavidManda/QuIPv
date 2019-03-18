package com.quipv.app.Models;

public class GraphNodeWithoutNeighbours {
    private String name;
    private int index;
    private boolean isDriver;

    public GraphNodeWithoutNeighbours(GraphNode node){
        this.name = node.getName();
        this.index = node.getIndex();
        this.isDriver = node.isDriver();
    }

    public GraphNodeWithoutNeighbours(String name, int index, boolean isDriver){
        this.name = name;
        this.index = index;
        this.isDriver = isDriver;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
