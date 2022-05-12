public class SumValuesRecursive {
    public static int run(NodeNumber head) {
        if (head == null) return 0;
        return head.value + run(head.next);
    }
}
