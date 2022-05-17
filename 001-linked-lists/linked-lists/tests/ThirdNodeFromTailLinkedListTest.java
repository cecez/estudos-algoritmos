import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThirdNodeFromTailLinkedListTest {

    @Test
    void it_retrieves_the_third_node_from_the_tail_of_a_linked_list_with_many_nodes() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');
        Node nodeF = new Node('F');
        Node nodeG = new Node('G');

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = nodeG;

        assertEquals('E', ThirdNodeFromTailLinkedList.retrieve(nodeA));
    }

    @Test
    void it_retrieves_the_third_node_from_the_tail_of_a_linked_list_with_three_nodes() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');

        nodeA.next = nodeB;
        nodeB.next = nodeC;

        assertEquals('A', ThirdNodeFromTailLinkedList.retrieve(nodeA));
    }

    @Test
    void it_does_not_retrieve_the_third_node_from_the_tail_of_a_linked_list_with_two_nodes() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');

        nodeA.next = nodeB;

        assertNull(ThirdNodeFromTailLinkedList.retrieve(nodeA));
    }

    @Test
    void it_does_not_retrieve_the_third_node_from_the_tail_of_a_linked_list_without_nodes() {
        assertNull(ThirdNodeFromTailLinkedList.retrieve(null));
    }

}