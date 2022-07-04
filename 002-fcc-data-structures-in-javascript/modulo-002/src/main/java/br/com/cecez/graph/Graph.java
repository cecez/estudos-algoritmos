package br.com.cecez.graph;

import java.util.ArrayList;

public class Graph {

    private final ArrayList<NodeLink> adjacencyList;

    Graph() {
        this.adjacencyList = new ArrayList<NodeLink>();
    }

    public void addNode(Node node) {
        if (this.containsNode(node)) {
            return;
        }

        NodeLink nodeLink = new NodeLink(node);
        this.adjacencyList.add(nodeLink);
    }

    public boolean containsNode(Node node) {
        for (NodeLink link : this.adjacencyList) {
            if (link.node.data == node.data) {
                return true;
            }
        }
        return false;
    }

    public void addLinks(Node nodeSource, Node nodeDestination) {
        this.addNode(nodeSource);
        this.addNode(nodeDestination);
        this.addLink(nodeSource, nodeDestination);
        this.addLink(nodeDestination, nodeSource);
    }

    private void addLink(Node nodeSource, Node nodeDestination) {
        if (this.containsLink(nodeSource, nodeDestination)) {
            return;
        }

        for (NodeLink link : this.adjacencyList) {
            if (link.node.data == nodeSource.data) {
                link.links.add(nodeDestination);
            }
        }
    }

    public boolean containsLink(Node nodeSource, Node nodeDestination) {
        for (NodeLink link : this.adjacencyList) {
            if (link.node.data == nodeSource.data) {
                for (Node node : link.links) {
                    if (node.data == nodeDestination.data) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void removeNode(Node node) {
        ArrayList<Node> destinationNodesToBeRemoved = new ArrayList<>();
        for (NodeLink link : this.adjacencyList) {
            if (link.node.data == node.data) {
                destinationNodesToBeRemoved.addAll(link.links);
            }
        }

        for (Node destination : destinationNodesToBeRemoved) {
            this.removeLinks(node, destination);
        }

        this.adjacencyList.remove(new NodeLink(node));
    }

    public void removeLinks(Node nodeSource, Node nodeDestination) {
        this.removeLink(nodeSource, nodeDestination);
        this.removeLink(nodeDestination, nodeSource);
    }

    private void removeLink(Node nodeSource, Node nodeDestination) {
        for (NodeLink link : this.adjacencyList) {
            if (link.node.data == nodeSource.data) {
                link.links.remove(nodeDestination);
            }
        }
    }

    public ArrayList<NodeLink> getAdjacencyList() {
        // todo, do not return the adjacency list reference
        return (ArrayList<NodeLink>) this.adjacencyList.clone();
    }

}
