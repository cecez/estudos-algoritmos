package org.example;

public class WeightedQuickUnion {
    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return id[i];
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);
        if (proot == qroot) return;

        // choose smaller tree and update its size
        if (size[proot] < size[qroot]) {
            id[proot] = qroot;
            size[qroot] += size[proot];
        } else {
            id[qroot] = proot;
            size[proot] += size[qroot];
        }
    }
}
