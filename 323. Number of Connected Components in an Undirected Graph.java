public class Solution {

    private int[] parent;
    private int[] size;
    private int count;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for(int i = 0; i < n; i ++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] e : edges) {
            union(e[0], e[1]);
        }

        return count;
    }

    public int find(int p) {
        int root = p;

        // find root first
        while(root != parent[root]) {
            root = parent[root];
        }

        // path compression
        while(p != root) {
            int newP = parent[p];
            parent[p] = root;
            p = newP;
        }

        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ)return;

        if(size[rootP] < size[rootQ]) {
            size[rootQ] += size[rootP];
            parent[rootP] = rootQ;
        }
        else {
            size[rootP] += size[rootQ];
            parent[rootQ] = rootP;
        }

        count --;
    }
}
