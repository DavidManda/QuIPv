package com.quipv.app.Helpers;


import com.quipv.app.Models.*;

import java.util.*;
import java.util.stream.Collectors;

public class GraphHelper {
    public static Graph constructGraph(Project project){
        Graph graph = new Graph();
        List<Answer> answers = project.getAnswers();
        for(Answer answer : answers){
            String driver = answer.getDriver();
            if(driver == null)
                continue;
            List<String> outcomes = answer.getOutcomes();
            GraphNode driverNode = new GraphNode(driver, 1, true);
            for(String outcome : outcomes){
                if(outcome != null && !outcome.isEmpty()){
                    GraphNode outcomeNode = new GraphNode(outcome, 1, false);
                    graph.addEdge(driverNode, outcomeNode);
                    driverNode = outcomeNode;
                }
            }
        }

        return graph;
    }

    // This method returns a list of nodes without neighbours. To be used to send the list as a JSON, in order to support
    // cyclic graphs.
    public static List<GraphNodeWithoutNeighbours> getListOfNodes(Graph graph){
        List<GraphNodeWithoutNeighbours> nodes = new ArrayList<>();
        for(GraphNode node : graph.getVertices()){
            nodes.add(new GraphNodeWithoutNeighbours(node));
        }
        return nodes;
    }

    public static VisualisationGraph filterEdges(VisualisationGraph graph, Integer minWeight){
        List<GraphNodeWithoutNeighbours> vertices = graph.getVertices();
        List<Edge> edges = graph.getEdges();
        edges = edges.stream().filter(edge -> edge.getWeight() >= minWeight).collect(Collectors.toList());
        List<Integer> usedOriginIndices = edges.stream().map(Edge::getOriginIndex).collect(Collectors.toList());
        List<Integer> usedDestinationIndices = edges.stream().map(Edge::getDestinationIndex).collect(Collectors.toList());
        Set<Integer> usedIndices = new HashSet<Integer>(usedDestinationIndices);
        usedIndices.addAll(usedOriginIndices);
        vertices = vertices.stream().filter(vertex -> usedIndices.contains(vertex.getId())).collect(Collectors.toList());

        graph.setEdges(edges);
        graph.setVertices(vertices);
        return graph;
    }
}
