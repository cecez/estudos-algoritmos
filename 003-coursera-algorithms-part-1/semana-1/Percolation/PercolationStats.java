import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private final double[] x; // fraction of open sites

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("n e trials precisam ser positivos.");

        double totalSites = n*n;
        x = new double[trials];

        while (trials > 0) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = 1 + StdRandom.uniform(n);
                int col = 1 + StdRandom.uniform(n);
                if (!p.isOpen(row, col)) p.open(row, col);
            }

            x[trials-1] = p.numberOfOpenSites() / totalSites;
            trials--;
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(x);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(x);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double mean = mean();
        double s = stddev();
        double troot = Math.sqrt(x.length);
        return mean - ((CONFIDENCE_95 * s) / troot);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double mean = mean();
        double s = stddev();
        double troot = Math.sqrt(x.length);
        return mean + ((CONFIDENCE_95 * s) / troot);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, trials);
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }

}