import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumValuesRecursiveTest {

    @Test
    void it_sums_many_nodes() {
        NodeNumber node1 = new NodeNumber(1);
        NodeNumber node2 = new NodeNumber(2);
        NodeNumber node3 = new NodeNumber(3);
        NodeNumber node4 = new NodeNumber(4);
        NodeNumber node5 = new NodeNumber(5);
        NodeNumber node6 = new NodeNumber(6);
        NodeNumber node7 = new NodeNumber(7);
        NodeNumber node8 = new NodeNumber(8);
        NodeNumber node9 = new NodeNumber(9);
        NodeNumber node10 = new NodeNumber(10);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        assertEquals(55, SumValuesRecursive.run(node1));
    }

    @Test
    void it_sums_one_node() {
        assertEquals(1, SumValuesRecursive.run(new NodeNumber(1)));
    }

    @Test
    void it_sums_empty_list() {
        assertEquals(0, SumValuesRecursive.run(null));
    }
}