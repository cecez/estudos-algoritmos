public class PrintLinkedList {
    public static String print(Node head) {
        StringBuilder output = new StringBuilder("");
        Node current = head;

        while (current != null) {
            output.append(current.value).append(" -> ");
            current = current.next;
        }

        output.append("null");
        return output.toString();
    }
}
