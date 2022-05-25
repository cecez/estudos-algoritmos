import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipperListIterativeTest {

    @Test
    /*
     * null, null   => null
     * null, A      => A
     * A, null      => A
     * null, A-B    => A-B
     * A-B, null    => A-B
     */
    void it_tests_cases_with_empty_lists() {
        assertNull(ZipperListIterative.run(null, null));

        Node nodeA = new Node('A');
        Node zipListWithNullAndOneNode = ZipperListIterative.run(null, nodeA);
        Node zipListWithOneNodeAndNull = ZipperListIterative.run(nodeA, null);

        assertEquals(
                "A -> null",
                PrintLinkedList.print(zipListWithNullAndOneNode)
        );

        assertEquals(
                "A -> null",
                PrintLinkedList.print(zipListWithOneNodeAndNull)
        );

    }

    @Test
    /*
     * A, X-Y-Z     => A-X-Y-Z
     */
    void it_tests_cases_with_one_node_lists() {
        Node nodeA = new Node('A');
        Node nodeX = new Node('X');
        Node nodeY = new Node('Y');
        Node nodeZ = new Node('Z');

        nodeX.next = nodeY;
        nodeY.next = nodeZ;

        Node zipListWithOneNodeAndXYZ = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> Y -> Z -> null",
                PrintLinkedList.print(zipListWithOneNodeAndXYZ)
        );
    }

    @Test
    /*
     * A-B-C, X     => A-X-B-C
     */
    void it_tests_a_case_with_3_to_1_node_lists() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeX = new Node('X');
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        Node zipListABCtoX = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> B -> C -> null",
                PrintLinkedList.print(zipListABCtoX)
        );
    }

    @Test
    /*
         * A, X-Y       => A-X-Y
         */
    void it_tests_a_case_with_1_to_2_node_lists() {
        Node nodeA = new Node('A');
        Node nodeX = new Node('X');
        nodeX.next = new Node('Y');

        Node zipListAtoXY = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> Y -> null",
                PrintLinkedList.print(zipListAtoXY)
        );
    }

    @Test
    /*
     * A-B, X       => A-X-B
     */
    void it_tests_a_case_with_2_to_1_node_lists() {
        Node nodeA = new Node('A');
        nodeA.next = new Node('B');
        Node nodeX = new Node('X');

        Node zipListABtoX = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> B -> null",
                PrintLinkedList.print(zipListABtoX)
        );
    }

    @Test
    /*
         * A, X         => A-X
*/
    void it_tests_a_case_with_1_to_1_node_lists() {
        Node nodeA = new Node('A');
        Node nodeX = new Node('X');

        Node zipListAtoX = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> null",
                PrintLinkedList.print(zipListAtoX)
        );
    }

    @Test
    /*
     * A-B, X-Y     => A-X-B-Y
     */
    void it_tests_a_case_with_2_to_2_node_lists() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeX = new Node('X');
        Node nodeY = new Node('Y');
        nodeA.next = nodeB;
        nodeX.next = nodeY;

        Node zipListABtoXY = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> B -> Y -> null",
                PrintLinkedList.print(zipListABtoXY)
        );
    }

    @Test
    /*
         * A-B, X-Y-Z   => A-X-B-Y-Z
         */
    void it_tests_a_case_with_2_to_3_node_lists() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeX = new Node('X');
        Node nodeY = new Node('Y');
        Node nodeZ = new Node('Z');
        nodeA.next = nodeB;
        nodeX.next = nodeY;
        nodeY.next = nodeZ;

        Node zipListABtoXYZ = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> B -> Y -> Z -> null",
                PrintLinkedList.print(zipListABtoXYZ)
        );
    }

    @Test
    /*
         * A-B-C, X-Y   => A-X-B-Y-C         *
     */
    void it_tests_a_case_with_3_to_2_node_lists() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeX = new Node('X');
        Node nodeY = new Node('Y');
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeX.next = nodeY;

        Node zipListABCtoXY = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> B -> Y -> C -> null",
                PrintLinkedList.print(zipListABCtoXY)
        );
    }

    @Test
    /*
         * A-B, W-X-Y-Z => A-W-B-X-Y-Z
         */
    void it_tests_a_case_with_2_to_4_node_lists() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeW = new Node('W');
        Node nodeX = new Node('X');
        Node nodeY = new Node('Y');
        Node nodeZ = new Node('Z');
        nodeA.next = nodeB;
        nodeW.next = nodeX;
        nodeX.next = nodeY;
        nodeY.next = nodeZ;

        Node zipListABtoWXYZ = ZipperListIterative.run(nodeA, nodeW);

        assertEquals(
                "A -> W -> B -> X -> Y -> Z -> null",
                PrintLinkedList.print(zipListABtoWXYZ)
        );
    }

    @Test
    /*
     * A-B-C-D, X-Y => A-X-B-Y-C-D
     */
    void it_tests_a_case_with_4_to_2_node_lists() {
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeX = new Node('X');
        Node nodeY = new Node('Y');
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeX.next = nodeY;

        Node zipListABCDtoXY = ZipperListIterative.run(nodeA, nodeX);

        assertEquals(
                "A -> X -> B -> Y -> C -> D -> null",
                PrintLinkedList.print(zipListABCDtoXY)
        );
    }

}