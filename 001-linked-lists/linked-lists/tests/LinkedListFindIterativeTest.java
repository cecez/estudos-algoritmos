import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListFindIterativeTest {

    @Test
    void it_finds_a_value() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        assertTrue(LinkedListFindIterative.find(nodeA, 'B'));
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

        assertFalse(LinkedListFindIterative.find(nodeA, 'E'));
    }

    @Test
    void it_finds_a_value_in_a_single_node_list() {
        Node nodeA = new Node('A');

        assertTrue(LinkedListFindIterative.find(nodeA, 'A'));
    }

    @Test
    void it_does_not_find_a_value_in_an_empty_list() {
        assertFalse(LinkedListFindIterative.find(null, 'E'));
    }

}