public class LinkedListReturnValueFromIndex {
    public static Character retrieve(Node head, int requestedIndex) {

        Node current = head;
        int currentIndex = 0;

        while (current != null) {

            if (currentIndex == requestedIndex) {
                return current.value;
            }

            current = current.next;
            currentIndex++;

        }

        return null;
    }
}
