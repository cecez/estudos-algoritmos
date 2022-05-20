import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIterativeTest {

    @Test
    void it_reverses_a_multi_node_list() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        Node reversedList = ReverseIterative.run(nodeA);

        assertEquals(
                "D -> C -> B -> A -> null",
                PrintLinkedList.print(reversedList)
        );
    }

    @Test
    void it_reverses_a_double_node_list() {
        Node head = new Node('A');
        head.next = new Node('B');

        Node reversedList = ReverseIterative.run(head);

        assertEquals(
                "B -> A -> null",
                PrintLinkedList.print(reversedList)
        );
    }

    @Test
    void it_reverses_a_single_node_list() {
        Node head = new Node('A');
        Node reversedList = ReverseIterative.run(head);

        assertEquals(
                "A -> null",
                PrintLinkedList.print(reversedList)
        );
    }

    @Test
    void it_reverses_an_empty_list() {
        assertNull(ReverseIterative.run(null));
    }

}