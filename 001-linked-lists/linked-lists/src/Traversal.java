public class Traversal {

    public static String traversal(Node head) {
        StringBuilder output = new StringBuilder();

        Node current = head;
        while (current != null) {
            output.append(current.value);
            current = current.next;
        }

        return output.toString();
    }

}
