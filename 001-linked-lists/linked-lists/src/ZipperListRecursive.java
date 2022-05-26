public class ZipperListRecursive {
    public static Node run(Node headA, Node headB) {

        if (headA == null) return headB;
        if (headB == null) return headA;

        Node nextA = headA.next;
        headA.next = headB;
        run(headB, nextA);

        return headA;
    }
}
