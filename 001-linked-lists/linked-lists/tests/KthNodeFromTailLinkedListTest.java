import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthNodeFromTailLinkedListTest {

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

        assertEquals('D', KthNodeFromTailLinkedList.retrieve(nodeA, 4));
        assertEquals('E', KthNodeFromTailLinkedList.retrieve(nodeA, 3));
        assertEquals('F', KthNodeFromTailLinkedList.retrieve(nodeA, 2));
        assertEquals('G', KthNodeFromTailLinkedList.retrieve(nodeA, 1));
        assertNull(KthNodeFromTailLinkedList.retrieve(nodeA, 10));
    }

}