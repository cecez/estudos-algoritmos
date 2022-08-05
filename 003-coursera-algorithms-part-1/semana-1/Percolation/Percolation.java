public class Percolation {
    private int[] connection;
    private boolean[] site;
    private int[] size;
    private final int n;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Parâmetro n precisa ser positivo.");
        }
        this.n = n;
        this.openSites = 0;

        connection = new int[n*n+2];
        site = new boolean[n*n+2];
        size = new int[n*n+2];

        // virtual top (n*n) and bottom (n*n+1) sites
        connection[virtualTopIndex()] = n*n;
        connection[virtualBottomIndex()] = n*n+1;
        site[virtualTopIndex()] = true;
        site[virtualBottomIndex()] = true;
        size[virtualTopIndex()] = 1;
        size[virtualBottomIndex()] = 1;

        int i = 0;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                connection[i] = i;
                site[i] = false;
                size[i] = 1;

//                if (row == 1) {
//                    // union with virtual top site
//                    this.union(row, col, 0, 0);
//                }
//
//                if (row == n) {
//                    // union with virtual bottom site
//                    this.union(row, col, n+1, n+1);
//                }

                i++;
            }
        }

    }

    private int virtualTopIndex() {
        return n*n;
    }

    private int virtualBottomIndex() {
        return n*n+1;
    }

    private void union(int prow, int pcol, int qrow, int qcol) {
        int pindex = this.rowColToIndex(prow, pcol);
        int qindex = this.rowColToIndex(qrow, qcol);

        int proot = this.root(pindex);
        int qroot = this.root(qindex);
        if (proot == qroot) return;

        // choose smaller tree and update its size
        if (size[proot] < size[qroot]) {
            connection[proot] = qroot;
            size[qroot] += size[proot];
        } else {
            connection[qroot] = proot;
            size[proot] += size[qroot];
        }
    }

    private int rowColToIndex(int row, int col) {
        if (row == 0) return n*n;   // virtual top
        if (row == n+1) return n*n + 1; // virtual bottom
        return ((row - 1) * n) + (col - 1);
    }

    private int root(int i) {
        while (connection[i] != i) {
            connection[i] = connection[connection[i]];
            i = connection[i];
        }
        return connection[i];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        this.validaParametros(row, col);
        if (isOpen(row, col)) return;

        int pindex = this.rowColToIndex(row, col);
        site[pindex] = true;
        this.openSites++;

        if (row-1 >= 1 && isOpen(row-1, col)) union(row, col, row-1, col);
        if (col-1 >= 1 && isOpen(row, col-1)) union(row, col, row, col-1);
        if (col+1 <= n && isOpen(row, col+1)) union(row, col, row, col+1);
        if (row+1 <= n && isOpen(row+1, col)) union(row, col, row+1, col);
        if (row == 1) union(row, col, 0, 0);
        if (row == n) union(row, col, n+1, n+1);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        this.validaParametros(row, col);
        int index = this.rowColToIndex(row, col);
        return site[index];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        this.validaParametros(row, col);
        int index = this.rowColToIndex(row, col);
        return site[index] && this.connected(row, col, 0, 0);
    }

    private void validaParametros(int row, int col) {
        if (row <= 0 || col <= 0 || row > this.n || col > this.n) {
            throw new IllegalArgumentException("Parâmetro n precisa ser positivo.");
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return this.connected(0, 0, n+1, n+1);
    }

    private boolean connected(int prow, int pcol, int qrow, int qcol) {
        int pindex = this.rowColToIndex(prow, pcol);
        int qindex = this.rowColToIndex(qrow, qcol);
        return this.root(pindex) == this.root(qindex);
    }

}