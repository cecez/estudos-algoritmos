public class ReverseIterative {
    public static Node run(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node actual = current;
            current = current.next;
            actual.next = previous;
            previous = actual;
        }

        return previous;
    }


}
