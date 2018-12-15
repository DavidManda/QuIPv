package com.quipv.app.Models;

import java.util.Objects;

public class Edge {
    private GraphNode origin;
    private GraphNode destination;
    private Integer weight;

    public Edge(GraphNode origin, GraphNode destination, Integer weight){
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public GraphNode getOrigin() {
        return origin;
    }

    public GraphNode getDestination() {
        return destination;
    }

    public Integer getWeight() {
        return weight;
    }

    public void incrementWeight(Integer weight){
        this.weight += weight;
    }

    @Override
    public boolean equals(Object o){

        if(o == this){
            return true;
        }

        if(!(o instanceof Edge)){
            return false;
        }

        Edge edge = (Edge) o;

        return this.origin == edge.origin && this.destination == edge.destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.origin.hashCode(), this.destination.hashCode());
    }
}
