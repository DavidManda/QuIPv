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
}
