package com.quipv.app;

import com.quipv.app.Models.Graph;
import com.quipv.app.Models.GraphNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

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
        GraphNode node1 = new GraphNode("Test node 1", 1);
        GraphNode node2 = new GraphNode("Test node 2", 1);

        graph.addNode(node1);
        graph.addNode(node2);

        assertEquals( "Test node 1", graph.getVertices().get(0).getName());
        assertEquals( 2, graph.getVertices().size());
    }

    @Test
    public void testAddEdge(){
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("Test node 1", 1);
        GraphNode node2 = new GraphNode("Test node 2", 2);
        GraphNode node3 = new GraphNode("Test node 3", 4);

        graph.addEdge(node1, node2);
        graph.addEdge(node3, node2);

        assertEquals( 3, graph.getVertices().size());
        assertEquals(1, node1.getNeighbours().size());
        assertEquals(0, node2.getNeighbours().size());
        assertEquals(1, node3.getNeighbours().size());

        graph.addEdge(node2, node1);

        assertEquals( 3, graph.getVertices().size());
        assertEquals(1, node1.getNeighbours().size());
        assertEquals(1, node2.getNeighbours().size());
    }

    @Test
    public void testGetSourceNodes(){
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("Test node 1", 1);
        GraphNode node2 = new GraphNode("Test node 2", 1);

        graph.addEdge(node1, node2);

        assertEquals(1, graph.getSourceNodes().size());
        assertEquals(node1, graph.getSourceNodes().get(0));
    }
}
