package com.quipv.app.Models;

public class GraphNodeWithoutNeighbours {
    private String name;
    private int id;
    private boolean isDriver;
    private Float x;
    private Float y;

    public GraphNodeWithoutNeighbours(GraphNode node){
        this.name = node.getName();
        this.id = node.getIndex();
        this.isDriver = node.isDriver();
    }

    public GraphNodeWithoutNeighbours(String name, int index, boolean isDriver, Float x, Float y){
        this.name = name;
        this.id = index;
        this.isDriver = isDriver;
        this.x = x;
        this.y = y;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
