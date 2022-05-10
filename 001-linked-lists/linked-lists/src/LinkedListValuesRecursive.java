import java.util.ArrayList;
import java.util.List;

public class LinkedListValuesRecursive {

    public static List<Character> linkedListValuesRecursive(Node head) {
        List<Character> values = new ArrayList<>();
        fillValues(head, values);
        return values;
    }

    private static void fillValues(Node head, List<Character> values) {
        if (head == null) return;

        values.add(head.value);
        fillValues(head.next, values);
    }
}
