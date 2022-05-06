public class TraversalRecursive {
    public static String traversalRecursive(Node current) {
        StringBuilder output = new StringBuilder();

        if (current != null) {
            output.append(current.value);
            output.append(traversalRecursive(current.next));
        }

        return output.toString();
    }
}
