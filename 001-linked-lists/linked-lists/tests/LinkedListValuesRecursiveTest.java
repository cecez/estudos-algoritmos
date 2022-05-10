import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListValuesRecursiveTest {

    @Test
    void linkedListWithFourElements() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        assertEquals(List.of('A', 'B', 'C', 'D'), LinkedListValuesRecursive.linkedListValuesRecursive(nodeA));
    }

    @Test
    void linkedListWithOneElement() {
        Node nodeA = new Node('A');
        assertEquals(List.of('A'), LinkedListValuesRecursive.linkedListValuesRecursive(nodeA));
    }

    @Test
    void linkedListWithoutElements() {
        assertEquals(List.of(), LinkedListValuesRecursive.linkedListValuesRecursive(null));
    }
}