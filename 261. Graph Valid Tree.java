// reference:http://www.geeksforgeeks.org/union-find/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(n);

        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            int root1 = wquf.find(node1);
            int root2 = wquf.find(node2);

            if(root1 == root2)return false;

            wquf.union(node1, node2);
        }
        return wquf.count() == 1;
    }
}


class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(int n) {
        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i ++) {
            parent[i] = i;
            size[i] = 1;
            count ++;
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
