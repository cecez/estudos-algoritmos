public class ThirdNodeFromTailLinkedList {
    public static Character retrieve(Node head) {
        if (head == null) return null;
        if (head.next == null) return null;
        if (head.next.next == null) return null;

        Node third = head;
        Node second = head.next;
        Node first = head.next.next;
        Node tail = head.next.next.next;

        while (tail != null) {
            third = second;
            second = first;
            first = tail;
            tail = tail.next;
        }

        return third.value;
    }


}
