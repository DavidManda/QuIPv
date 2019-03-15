package com.quipv.app;


import com.quipv.app.Models.Graph;
import com.quipv.app.Models.GraphNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphTest
{

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testAddNode()
    {
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("Test node 1", 1, true);
        GraphNode node2 = new GraphNode("Test node 2", 1, true);

        graph.addNode(node1);
        graph.addNode(node2);

        Assert.assertEquals( "Test node 1", graph.getVertices().get(0).getName());
        Assert.assertEquals( 2, graph.getVertices().size());
    }

    @Test
    public void testAddEdge(){
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("Test node 1", 1, true);
        GraphNode node2 = new GraphNode("Test node 2", 2, false);
        GraphNode node3 = new GraphNode("Test node 3", 4, false);

        graph.addEdge(node1, node2);
        graph.addEdge(node3, node2);

        Assert.assertEquals( 3, graph.getVertices().size());
        Assert.assertEquals(1, node1.getNeighbours().size());
        Assert.assertEquals(0, node2.getNeighbours().size());
        Assert.assertEquals(1, node3.getNeighbours().size());

        graph.addEdge(node2, node1);

        Assert.assertEquals( 3, graph.getVertices().size());
        Assert.assertEquals(1, node1.getNeighbours().size());
        Assert.assertEquals(1, node2.getNeighbours().size());
    }

    @Test
    public void testGetSourceNodes(){
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("Test node 1", 1, true);
        GraphNode node2 = new GraphNode("Test node 2", 1, true);

        graph.addEdge(node1, node2);

        Assert.assertEquals(1, graph.getSourceNodes().size());
        Assert.assertEquals(node1, graph.getSourceNodes().get(0));
    }

    @Test
    public void testCitationCount(){
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("T1", 1, true);
        GraphNode node2 = new GraphNode("T2", 1, true);
        GraphNode node3 = new GraphNode("T3", 7, true);

        //Test node added with initial weight 1
        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        Assert.assertEquals(1, getEdgeWeight(graph, "T1", "T2"));
        Assert.assertEquals(1, getEdgeWeight(graph, "T1", "T3"));

        //Test weight is added on duplicate edge
        graph.addEdge(node1, node2);
        Assert.assertEquals(2, getEdgeWeight(graph, "T1", "T2"));

        //Test nodes are directed
        graph.addEdge(node2, node1);
        Assert.assertEquals(1, getEdgeWeight(graph, "T2", "T1"));
        Assert.assertEquals(2,getEdgeWeight(graph, "T1", "T2"));
    }

    private int getEdgeWeight(Graph graph, String source, String destination){
        return graph.getEdges().stream()
                .filter(p -> p.getOriginIndex() == graph.getNodeByName(source).get().getIndex())
                .filter(p -> p.getDestinationIndex() == graph.getNodeByName(destination).get().getIndex())
                .findFirst().get().getWeight();
    }
}
