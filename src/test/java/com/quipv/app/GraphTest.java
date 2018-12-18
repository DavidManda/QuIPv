package com.quipv.app;

import com.quipv.app.Helpers.GraphHelper;
import com.quipv.app.Helpers.ProjectHelper;
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

//    public void testDbGraph(){
//        Graph graph = GraphHelper.constructGraph(ProjectHelper.populate());
//
//        System.out.println(graph.getVertices().indexOf(new GraphNode("O1",1)));
//        GraphNode o_1 = graph.getVertices().get(graph.getVertices().indexOf(new GraphNode("O1",1)));
//        GraphNode p_1 = graph.getVertices().get(graph.getVertices().indexOf(new GraphNode("P1",1)));
//
//        assertEquals(3, o_1.getNeighbours().size());
//        assertEquals(3, p_1.getNeighbours().size());
//
//        for(GraphNode node : graph.getVertices()){
//            System.out.println(node.getIndex());
//        }
//    }

    public void testGetSourceNodes(){
        Graph graph = new Graph();
        GraphNode node1 = new GraphNode("Test node 1", 1);
        GraphNode node2 = new GraphNode("Test node 2", 1);

        graph.addEdge(node1, node2);

        assertEquals(1, graph.getSourceNodes().size());
        assertEquals(node1, graph.getSourceNodes().get(0));
    }
}
