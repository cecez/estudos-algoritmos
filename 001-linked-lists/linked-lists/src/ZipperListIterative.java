public class ZipperListIterative {
    public static Node run(Node headA, Node headB) {

        if (headA == null) return headB;
        if (headB == null) return headA;

        Node currentList = headA;
        Node otherList = headB;

        while (currentList != null && otherList != null) {
            Node next = currentList.next;
            currentList.next = otherList;

            currentList = otherList;
            otherList = next;
        }

        return headA;
    }
}
