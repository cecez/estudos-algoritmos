import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumValuesIterativeTest {

    @Test
    void it_sums_many_node() {
        NodeNumber nodeOne = new NodeNumber(1);
        NodeNumber nodeTwo = new NodeNumber(2);
        NodeNumber nodeThree = new NodeNumber(3);
        NodeNumber nodeFour = new NodeNumber(4);

        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;

        assertEquals(10, SumValuesIterative.run(nodeOne));
    }

    @Test
    void it_sums_with_a_single_node() {
        NodeNumber nodeOne = new NodeNumber(1);

        assertEquals(1, SumValuesIterative.run(nodeOne));
    }

    @Test
    void it_sums_with_an_empty_list() {
        assertEquals(0, SumValuesIterative.run(null));
    }
}