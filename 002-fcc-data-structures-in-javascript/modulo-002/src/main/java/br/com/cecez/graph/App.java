package br.com.cecez.graph;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Graph graph = new Graph();
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');

        graph.addNode(nodeA);
        graph.addLinks(nodeB, nodeC);
        graph.addLinks(nodeD, nodeC);
        graph.addNode(nodeE);


    }
}
