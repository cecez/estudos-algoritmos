import java.util.ArrayList;
import java.util.List;

public class LinkedListValues {
    public static List<Character> linkedListValues(Node head) {
        List<Character> values = new ArrayList<>();

        Node current = head;
        while (current != null) {
            values.add(current.value);
            current = current.next;
        }

        return values;
    }
}
