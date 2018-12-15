package com.quipv.app.Models;

import java.util.*;

public class Graph extends ArrayList<GraphNode> {

    private Set<GraphNode> verticesSet;
    private List<GraphNode> vertices;
    private List<Edge> edges;

    public Graph(){
        this.vertices = new ArrayList<>();
        this.verticesSet = new HashSet<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(GraphNode node){

        if(isNotInGraph(node)){
            this.verticesSet.add(node);
            this.vertices.add(node);
        }
    }

    public void addEdge(GraphNode node, GraphNode neighbour){

        Edge edge = new Edge(node, neighbour, 1);
        if(isNotInGraph(edge)){
            edges.add(edge);
        }
        else {
            Integer edgeIndex = edges.indexOf(edge);
            Edge oldEdge = edges.get(edgeIndex);
            edge.incrementWeight(oldEdge.getWeight());
            edges.set(edgeIndex, edge);
        }

        node.addNeighbour(neighbour, 1);
        if(isNotInGraph(node)){
            addNode(node);
        }

        if(isNotInGraph(neighbour)){
            addNode(neighbour);
        }


    }

    public List<GraphNode> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges(){
        return edges;
    }

    private boolean isNotInGraph(GraphNode node){
        return !this.verticesSet.contains(node);
    }

    private boolean isNotInGraph(Edge edge){
        return this.edges.contains(edge);
    }
}
