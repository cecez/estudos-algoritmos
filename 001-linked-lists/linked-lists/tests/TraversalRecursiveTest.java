import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraversalRecursiveTest {
    @Test
    void traversalWithNodes() {
        Node nodoA = new Node('A');
        Node nodoB = new Node('B');
        Node nodoC = new Node('C');
        Node nodoD = new Node('D');
        nodoA.next = nodoB;
        nodoB.next = nodoC;
        nodoC.next = nodoD;

        assertEquals("ABCD", TraversalRecursive.traversalRecursive(nodoA));
    }

    @Test
    void traversalWithOneNode() {
        Node nodoA = new Node('A');
        assertEquals("A", TraversalRecursive.traversalRecursive(nodoA));
    }

    @Test
    void traversalWithoutNodes() {
        assertEquals("", TraversalRecursive.traversalRecursive(null));
    }

}