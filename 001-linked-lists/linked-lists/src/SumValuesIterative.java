public class SumValuesIterative {
    public static int run(NodeNumber head) {
        int sum = 0;
        NodeNumber current = head;
        while (current != null) {
            sum += current.value;
            current = current.next;
        }
        return sum;
    }
}
