class Solution {
    public int countComponents(int n, int[][] edges) {

        WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(n);
        for(int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];

            wquf.union(i, j);
        }
        return wquf.count();
    }
}


class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for(int i = 0; i < n; i ++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        // get root first
        while(parent[root] != root) {
            root = parent[root];
        }
        // path compression
        while(parent[p] != root) {
            int oldP = parent[p];
            parent[p] = root;
            p = parent[p];
        }
        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ)return;

        if(size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count --;
    }

    public int count() {
        return count;
    }
}
