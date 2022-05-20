public class ReverseRecursive {
    public static Node reverse(Node head, Node previous) {
        if (head == null) return previous;

        Node next = head.next;
        head.next = previous;

        return ReverseRecursive.reverse(next, head);
    }
}
