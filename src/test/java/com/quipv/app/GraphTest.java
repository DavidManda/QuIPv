package com.quipv.app;

import com.quipv.app.Models.Graph;
import com.quipv.app.Models.GraphNode;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GraphTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GraphTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GraphTest.class );
    }


    /**
     * Rigourous Test :-)
     */
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

    public void testAddEdge(){
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("Test node 1", 1);
        GraphNode node2 = new GraphNode("Test node 2", 1);

        graph.addEdge(node1, node2);

        assertEquals( 2, graph.getVertices().size());
        assertEquals(1, node1.getNeighbours().size());
        assertEquals(0, node2.getNeighbours().size());

        graph.addEdge(node2, node1);

        assertEquals( 2, graph.getVertices().size());
        assertEquals(1, node1.getNeighbours().size());
        assertEquals(1, node2.getNeighbours().size());
    }
}
