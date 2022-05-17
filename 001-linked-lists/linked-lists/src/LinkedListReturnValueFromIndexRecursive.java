public class LinkedListReturnValueFromIndexRecursive {
    public static Character retrieve(Node head, int requestedIndex) {
        if (requestedIndex < 0) return null;
        if (head == null) return null;
        if (requestedIndex == 0) return head.value;
        return retrieve(head.next, requestedIndex - 1);
    }
}
