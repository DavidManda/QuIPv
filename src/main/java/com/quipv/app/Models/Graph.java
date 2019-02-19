package com.quipv.app.Models;

import java.util.*;
import java.util.stream.Collectors;

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
            node.setIndex(this.vertices.size()-1);
        }
    }

    public void addEdge(GraphNode node, GraphNode neighbour){

        if(isInGraph(node)){
            node = this.vertices.get(this.vertices.indexOf(node));
        }

        if(isInGraph(neighbour)){
            neighbour = this.vertices.get(this.vertices.indexOf(neighbour));
        }

        node.addNeighbour(neighbour, 1);
        addNode(node);
        addNode(neighbour);

        Edge edge = new Edge(node, neighbour, 1);

        Integer edgeIndex = edges.indexOf(edge);
        if(edgeIndex == -1){
            edges.add(edge);
        }
        else {
            Edge oldEdge = edges.get(edgeIndex);
            edge.incrementWeight(oldEdge.getWeight());
            edges.set(edgeIndex, edge);
        }
    }

    public List<GraphNode> getVertices() {
        return vertices;
    }

    public Optional<GraphNode> getNodeByName(String name){
        for(GraphNode node : this.vertices){
            if(node.getName().equals(name)){
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    // returns a list of nodes that have no parents
    public List<GraphNode> getSourceNodes(){
        List<GraphNode> sourceNodes;
        Boolean[] nodeIsReached = new Boolean[vertices.size()];

        Arrays.fill(nodeIsReached, Boolean.FALSE);

        for(GraphNode vertex : vertices){
            for(Neighbour neighbour : vertex.getNeighbours()){
                nodeIsReached[neighbour.node.getIndex()] = true;
            }
        }
        sourceNodes = vertices.stream().filter(vertex -> !nodeIsReached[vertex.getIndex()]).collect(Collectors.toList());
        return sourceNodes;
    }
    private boolean isNotInGraph(GraphNode node){
        return !this.verticesSet.contains(node);
    }

    private boolean isInGraph(GraphNode node){
        return this.verticesSet.contains(node);
    }

}
