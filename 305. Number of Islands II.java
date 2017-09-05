class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(positions == null || positions.length == 0 || m <= 0 || n <= 0)return result;

        WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(m, n);

        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for(int[] position : positions) {
            int i = position[0];
            int j = position[1];

            int index1 = Index2DTo1D(i, j, n);
            wquf.set(index1);
            for(int[] dir : dirs) {
                // 1. check index is valid or not
                if(isValidIndex(i + dir[0], j + dir[1], m, n)){
                    int index2 = Index2DTo1D(i + dir[0], j + dir[1], n);
                    // 2. check node has value or not(-1 means no nodes)
                    int value = wquf.get(index2);
                    if(value >= 0)wquf.union(index1, index2);
                }
            }

            result.add(wquf.count());
        }

        return result;
    }

    public int Index2DTo1D(int i, int j, int n) {
        return i * n + j;
    }

    public boolean isValidIndex(int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n)return false;
        else return true;
    }
}

class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(int m, int n) {
        parent = new int[m * n];
        size = new int[m * n];

        for(int i = 0; i < m * n; i ++) {
            parent[i] = -1;
            size[i] = 0;
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

    public void set(int index) {
        if(parent[index] == -1 && size[index] == 0) {
            parent[index] = index;
            size[index] = 1;
            count ++;
        }
    }

    public int get(int index) {
        return parent[index];
    }
}
