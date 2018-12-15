package com.quipv.app.Models;

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
}
