package com.quipv.app.Models;

import java.util.Objects;

public class Edge {
    private Integer originIndex;
    private Integer destinationIndex;
    private Integer weight;

    public Edge(GraphNode origin, GraphNode destination, Integer weight){
        this.originIndex = origin.getIndex();
        this.destinationIndex = destination.getIndex();
        this.weight = weight;
    }

    public Integer getOriginIndex() {
        return originIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
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

        return this.originIndex == edge.originIndex && this.destinationIndex == edge.destinationIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.originIndex.hashCode(), this.destinationIndex.hashCode());
    }
}
