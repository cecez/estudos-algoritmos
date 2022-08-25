import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        if (k == 0) return;

        String nextString;
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            nextString = StdIn.readString();
            rq.enqueue(nextString);
        }

        for (int i = 1; i <= k; i++) {
            StdOut.println(rq.dequeue());
        }
    }
}