import static org.junit.jupiter.api.Assertions.*;

class TraversalTest {

    @org.junit.jupiter.api.Test
    void traversal() {

        Node nodoA = new Node('A');
        Node nodoB = new Node('B');
        Node nodoC = new Node('C');
        Node nodoD = new Node('D');

        nodoA.next = nodoB;
        nodoB.next = nodoC;
        nodoC.next = nodoD;

        assertEquals("ABCD", Traversal.traversal(nodoA));
    }
}