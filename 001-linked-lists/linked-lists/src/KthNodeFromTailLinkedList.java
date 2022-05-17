public class KthNodeFromTailLinkedList {
    // Tortoise and Hare algorithm to return the kth node from the end
    public static Character retrieve(Node head, int k) {
        Node slow = head;
        Node fast = head;
        int traversedNodes = 0;

        while (fast != null) {
            if (traversedNodes >= k) {
                slow = slow.next;
            }

            traversedNodes++;
            fast = fast.next;
        }

        if (traversedNodes < k) return null;
        assert slow != null;
        return slow.value;
    }
}
