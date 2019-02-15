package com.quipv.app.Helpers;


import com.quipv.app.Models.Answer;
import com.quipv.app.Models.Graph;
import com.quipv.app.Models.GraphNode;
import com.quipv.app.Models.Project;

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
}
