class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)return;

        // + 1 for the dummy node
        int length = board.length * board[0].length + 1;
        WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(length);

        int m = board.length;
        int n = board[0].length;

        // find components connected to boundary
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(board[i][j] == 'O') {
                    // if on boundary, it won't be closed
                    if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        int index = Index2DTo1D(i, j, n);
                        // dummy node index is the last additional one
                        int dummyIndex = m * n;
                        wquf.union(index, dummyIndex);
                    }
                    // then, connect to nearby components
                    // right
                    if(j + 1 < n && board[i][j + 1] == 'O') {
                        int index1 = Index2DTo1D(i, j, n);
                        int index2 = Index2DTo1D(i, j + 1, n);
                        wquf.union(index1, index2);
                    }
                    // down
                    if(i + 1 < m && board[i + 1][j] == 'O') {
                        int index1 = Index2DTo1D(i, j, n);
                        int index2 = Index2DTo1D(i + 1, j, n);
                        wquf.union(index1, index2);
                    }
                }
            }
        }
        // revert closed components to 'X'
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(board[i][j] == 'O') {
                    int index = Index2DTo1D(i, j, n);
                    int dummyIndex = m * n;

                    if(!wquf.isConnected(index, dummyIndex)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public int Index2DTo1D(int i, int j, int n) {
        return i * n + j;
    }
}

class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;

    public WeightedQuickUnionUF(int n) {
        parent = new int[n];
        size = new int[n];

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
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
