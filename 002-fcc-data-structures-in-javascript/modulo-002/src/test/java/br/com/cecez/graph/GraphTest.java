package br.com.cecez.graph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GraphTest
{
    private Graph graph;
    private Node nodeA, nodeB, nodeC, nodeD, nodeE;

    @Before
    public void setup() {
        this.graph = new Graph();
        this.nodeA = new Node('A');
        this.nodeB = new Node('B');
        this.nodeC = new Node('C');
        this.nodeD = new Node('D');
        this.nodeE = new Node('E');

        this.graph.addLinks(this.nodeB, this.nodeC);
        this.graph.addLinks(this.nodeD, this.nodeC);
    }

    @Test
    public void it_should_add_a_node()
    {
        this.graph.addNode(this.nodeA);
        this.graph.addNode(this.nodeA);

        assertTrue(this.graph.containsNode(this.nodeA));
        assertFalse(this.graph.containsNode(this.nodeE));
    }

    @Test
    public void it_should_add_a_link()
    {
        this.graph.addLinks(this.nodeA, this.nodeC);

        assertTrue(this.graph.containsLink(this.nodeA, this.nodeC));
        assertTrue(this.graph.containsLink(this.nodeC, this.nodeA));
        assertFalse(this.graph.containsLink(this.nodeA, this.nodeB));
    }

    @Test
    public void it_should_remove_a_link()
    {
        this.graph.removeLinks(this.nodeC, this.nodeB);

        assertFalse(this.graph.containsLink(this.nodeB, this.nodeC));
        assertFalse(this.graph.containsLink(this.nodeC, this.nodeA));
        assertTrue(this.graph.containsLink(this.nodeC, this.nodeD));
    }

    @Test
    public void it_should_remove_a_node() {
        this.graph.removeNode(this.nodeD);

        assertFalse(this.graph.containsLink(this.nodeD, this.nodeC));
        assertFalse(this.graph.containsLink(this.nodeC, this.nodeD));
        assertTrue(this.graph.containsLink(this.nodeC, this.nodeB));
        assertTrue(this.graph.containsLink(this.nodeB, this.nodeC));
        assertTrue(this.graph.containsNode(this.nodeC));
        assertFalse(this.graph.containsNode(this.nodeD));
    }
}
