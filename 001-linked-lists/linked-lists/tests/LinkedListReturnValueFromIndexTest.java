import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListReturnValueFromIndexTest {
    @Test
    void it_should_return_the_value_at_the_given_index() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        assertEquals('B', LinkedListReturnValueFromIndex.retrieve(nodeA, 1));
    }

    @Test
    void it_should_return_null_if_the_index_is_out_of_bounds() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        assertNull(LinkedListReturnValueFromIndex.retrieve(nodeA, 5));
    }

    @Test
    void it_should_return_null_if_the_index_is_negative() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        assertNull(LinkedListReturnValueFromIndex.retrieve(nodeA, -1));
    }

    @Test
    void it_should_return_a_value_if_the_index_is_zero_and_is_not_an_empty_list() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        assertEquals('A', LinkedListReturnValueFromIndex.retrieve(nodeA, 0));
    }

    @Test
    void it_should_return_null_with_an_empty_list() {
        assertNull(LinkedListReturnValueFromIndex.retrieve(null, 2));
    }

    @Test
    void it_should_return_a_value_with_a_single_node_list() {
        Node nodeA = new Node('A');
        assertEquals('A', LinkedListReturnValueFromIndex.retrieve(nodeA, 0));
    }
}