package org.example;

public class UnionFind {
    private int[] id;

    public UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int oldValue = id[p];
        int newValue = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == oldValue) {
                id[i] = newValue;
            }
        }
    }
}
