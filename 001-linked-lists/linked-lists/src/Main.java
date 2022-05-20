public class Main {
    public static void main(String[] args) {
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('c');
        head.next.next.next = new Node('d');
        head.next.next.next.next = new Node('e');
        head.next.next.next.next.next = new Node('f');

        PrintLinkedList.print(head);

        System.out.println("\n");

        Node newHead = ReverseRecursive.reverse(head, null);

        PrintLinkedList.print(newHead);
    }
}