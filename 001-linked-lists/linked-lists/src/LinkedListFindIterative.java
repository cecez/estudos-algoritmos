public class LinkedListFindIterative {
    public static boolean find(Node head, char targetValue) {
        Node current = head;
        while (current != null) {
            if (current.value == targetValue) return true;
            current = current.next;
        }
        return false;
    }
}
