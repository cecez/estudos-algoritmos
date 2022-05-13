import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListFindRecursiveTest {

    @Test
    void it_finds_a_value() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        assertTrue(LinkedListFindRecursive.find(nodeA, 'B'));
    }

    @Test
    void it_does_not_find_a_value() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        assertFalse(LinkedListFindRecursive.find(nodeA, 'E'));
    }

    @Test
    void it_finds_a_value_in_a_single_node_list() {
        Node nodeA = new Node('A');

        assertTrue(LinkedListFindRecursive.find(nodeA, 'A'));
    }

    @Test
    void it_does_not_find_a_value_in_an_empty_list() {
        assertFalse(LinkedListFindRecursive.find(null, 'E'));
    }

}