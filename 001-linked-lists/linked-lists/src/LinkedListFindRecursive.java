public class LinkedListFindRecursive {
    public static boolean find(Node head, char targetValue) {
        if (head == null) return false;
        if (head.value == targetValue) return true;
        return LinkedListFindRecursive.find(head.next, targetValue);
    }
}
