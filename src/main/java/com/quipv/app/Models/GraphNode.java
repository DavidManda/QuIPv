package com.quipv.app.Models;

/*
 *Structure for storing a node in the causal chain
 *Contains name, weight & list of respondents
 */

import java.util.*;
import java.util.stream.Collectors;

public class GraphNode {
    private String name;
    private int count;
    private int index;
    private boolean isDriver;
    private ArrayList<Neighbour> neighbours;
    private float x;
    private float y;

    public GraphNode(String name, int count, boolean isDriver) {
        this.name = name;
        this.count = count;
        this.isDriver = isDriver;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(GraphNode node, Integer weight){
        Neighbour neighbour = new Neighbour(node, weight);
        Integer neighbourIndex = this.neighbours.indexOf(neighbour);
        if(neighbourIndex != -1){
            Integer currentWeight = this.neighbours.get(neighbourIndex).weight;
            neighbour.weight += currentWeight;
            this.neighbours.set(neighbourIndex, neighbour);
        }
        this.neighbours.add(neighbour);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {this.count = count;}

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ArrayList<Neighbour> getNeighbours() {
        return neighbours;
    }

    public ArrayList<GraphNode> getNeighbourNodes(){return neighbours.stream().map(neighbour -> neighbour.node).collect(Collectors.toCollection(ArrayList::new));}

    @Override
    public boolean equals(Object o){

        if(o == this){
            return true;
        }

        if(!(o instanceof GraphNode)){
            return false;
        }

        GraphNode node = (GraphNode) o;

        return this.name.equals(node.getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString(){
        return this.name;
    }
}