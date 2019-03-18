package com.quipv.app.Models;

import java.util.List;

public class VisualisationGraph {
    private List<GraphNodeWithoutNeighbours> vertices;
    private List<Edge> edges;

    public VisualisationGraph(List<GraphNodeWithoutNeighbours> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<GraphNodeWithoutNeighbours> getVertices() {
        return vertices;
    }

    public void setVertices(List<GraphNodeWithoutNeighbours> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
