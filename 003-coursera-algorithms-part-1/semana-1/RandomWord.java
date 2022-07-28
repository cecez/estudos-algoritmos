import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {
        String nextString, championString = "";
        int words = 0;
        double p;

        while (!StdIn.isEmpty()) {
            words++;
            nextString = StdIn.readString();
            p = 1.0 / words;
            if (StdRandom.bernoulli(p)) {
                championString = nextString;
            }
        }

        StdOut.println(championString);
    }

}