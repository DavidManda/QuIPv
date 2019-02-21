package com.quipv.app.Helpers;


import com.quipv.app.Models.*;

import java.util.ArrayList;
import java.util.List;

public class GraphHelper {
    public static Graph constructGraph(Project project){
        Graph graph = new Graph();
        List<Answer> answers = project.getAnswers();

        for(Answer answer : answers){
            String driver = answer.getDriver();
            List<String> outcomes = answer.getOutcomes();
            GraphNode driverNode = new GraphNode(driver, 1);
            for(String outcome : outcomes){
                GraphNode outcomeNode = new GraphNode(outcome, 1);
                graph.addEdge(driverNode, outcomeNode);
                driverNode = outcomeNode;
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
}
