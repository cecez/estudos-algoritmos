package br.com.cecez.graph;

import java.util.ArrayList;

public class NodeLink {
    Node node;
    ArrayList<Node> links;

    NodeLink(Node node) {
        this.node = node;
        this.links = new ArrayList<Node>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) return false;
        NodeLink nodeLink = (NodeLink) obj;
        return this.node.data == nodeLink.node.data;
    }
}
