class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(grid);

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == '0')continue;
                // right
                if(j + 1 < n && grid[i][j + 1] == '1') {
                    int index1 = Index2DTo1D(i, j, n);
                    int index2 = Index2DTo1D(i, j + 1, n);
                    wquf.union(index1, index2);
                }
                // bottom
                if(i + 1 < m && grid[i + 1][j] == '1') {
                    int index1 = Index2DTo1D(i, j, n);
                    int index2 = Index2DTo1D(i + 1, j, n);
                    wquf.union(index1, index2);
                }
            }
        }
        
        return wquf.count();
    }

    public int Index2DTo1D(int i, int j, int n) {
        return i * n + j;
    }
}


class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionUF(char[][] grid) {
        for(int i = 0; i < grid.length; i ++) {
            for(int j = 0; j < grid[0].length; j ++) {
                if(grid[i][j] == '1')count ++;
            }
        }
        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        size = new int[m * n];

        for(int i = 0; i < m * n; i ++) {
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

// sol2
// public class Solution {
//     public int numIslands(char[][] grid) {
//         if(grid == null || grid.length == 0)return 0;
//         int count = 0;
//         for(int i = 0; i < grid.length; i ++) {
//             for(int j = 0; j < grid[0].length; j ++) {
//                 if(grid[i][j] == '1') {
//                     count ++;
//                     dfs(grid, i, j);
//                 }
//             }
//         }
//         return count;
//     }
//     public void dfs(char[][] grid, int i, int j) {
//         if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return;
//         if(grid[i][j] == '0')return;
//
//         grid[i][j] = '0';
//         dfs(grid, i + 1, j);
//         dfs(grid, i - 1, j);
//         dfs(grid, i, j + 1);
//         dfs(grid, i, j - 1);
//     }
// }
//
