package org.example;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
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
        id[proot] = qroot;
    }
}
