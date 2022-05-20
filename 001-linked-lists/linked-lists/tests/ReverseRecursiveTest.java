import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseRecursiveTest {

    @Test
    void it_reverses_a_multi_node_list() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        Node reversedList = ReverseRecursive.reverse(nodeA, null);

        assertEquals(
                "D -> C -> B -> A -> null",
                PrintLinkedList.print(reversedList)
        );
    }

    @Test
    void it_reverses_a_double_node_list() {
        Node head = new Node('A');
        head.next = new Node('B');

        Node reversedList = ReverseRecursive.reverse(head, null);

        assertEquals(
                "B -> A -> null",
                PrintLinkedList.print(reversedList)
        );
    }

    @Test
    void it_reverses_a_single_node_list() {
        Node head = new Node('A');
        Node reversedList = ReverseRecursive.reverse(head, null);

        assertEquals(
                "A -> null",
                PrintLinkedList.print(reversedList)
        );
    }

    @Test
    void it_reverses_an_empty_list() {
        assertNull(ReverseRecursive.reverse(null, null));
    }

}