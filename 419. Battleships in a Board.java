// dfs
/* public class Solution {
 *     private int[] direction_x = {1, 0, 1, 0};
 *     private int[] direction_y = {0, 1, 0, 1};
 *
 *     public int countBattleships(char[][] board) {
 *         if(board == null || board[0].length == 0)return 0;
 *
 *         int m = board.length;
 *         int n = board[0].length;
 *         int count = 0;
 *
 *
 *         for(int i = 0; i < m; i ++) {
 *             for(int j = 0; j < n; j ++) {
 *                 if(board[i][j] == '.')continue;
 *                 count ++;
 *                 dfs(board, i, j);
 *             }
 *         }
 *
 *         return count;
 *     }
 *
 *     public void dfs(char[][] board, int i, int j) {
 *         if(i < 0 || i == board.length || j < 0 || j == board[0].length)return;
 *
 *         if(board[i][j] == 'X') board[i][j] = '.';
 *         else return;
 *
 *         for(int idx = 0; idx < 4; idx ++) {
 *             dfs(board, i + direction_x[idx], j + direction_y[idx]);
 *         }
 *
 *     }
 * } */

// bfs
/* public class Solution {
 *    public int countBattleships(char[][] board) {
 *      if(board == null || board.length == 0 || board[0].length == 0)return 0;
 *              int m = board.length;
 *              int n = board[0].length;
 *              int count = 0;
 *
 *              for(int i = 0; i < m; i ++) {
 *                  for(int j = 0; j < n; j ++) {
 *                      char ch = board[i][j];
 *                      if(ch == '.')continue;
 *
 *                      count ++;
 *                      bfs(board, i, j);
 *                  }
 *              }
 *         return count;
 *    }
 *
 *    private void bfs(char[][] board, int i, int j) {
 *        int m = board.length;
 *        int n = board[0].length;
 *
 *         Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
 *         queue.add(new java.util.AbstractMap.SimpleEntry<>(i, j));
 *
 *         while(!queue.isEmpty()) {
 *             Map.Entry<Integer, Integer> entry = queue.poll();
 *             int x = entry.getKey();
 *             int y = entry.getValue();
 *
 *             board[x][y] = '.';
 *
 *             // right
 *             if(x < m && y + 1 < n && board[x][y + 1] == 'X') {
 *                 queue.add(new java.util.AbstractMap.SimpleEntry<>(x, y + 1));
 *             }
 *             // bottom
 *             else if(x + 1 < m && y < n && board[x + 1][y] == 'X') {
 *                 queue.add(new java.util.AbstractMap.SimpleEntry<>(x + 1, y));
 *             }
 *         }
 *         return;
 *    }
 * } */

// union find
/* public class Solution {
 *     public int countBattleships(char[][] board) {
 *         if(board == null || board.length == 0 || board[0].length == 0)return 0;
 *
 *         int m = board.length;
 *         int n = board[0].length;
 *         QuickUnionFind QUF = new QuickUnionFind(m * n);
 *
 *         int index1 = 0;
 *         int index2 = 0;
 *         for(int i = 0; i < m; i ++) {
 *             for(int j = 0; j < n; j ++) {
 *                 if(board[i][j] == '.')continue;
 *
 *                 index1 = i * n + j;
 *                 // bottom
 *                 if(i + 1 < m && j < n && board[i + 1][j] == 'X') {
 *                     index2 = (i + 1) * n + j;
 *                     QUF.union(index1, index2);
 *                 }
 *                 // right
 *                 else if(i < m && j + 1 < n && board[i][j + 1] == 'X') {
 *                     index2 = i * n + j + 1;
 *                     QUF.union(index1, index2);
 *                 }
 *             }
 *         }
 *
 *         // only count the head of one battleship
 *         int count = 0;
 *         for(int i = 0; i < m; i ++) {
 *             for(int j = 0; j < n; j ++) {
 *                 if(board[i][j] == '.')continue;
 *
 *                 int index = i * n + j;
 *                 if(QUF.parent[index] == index)count ++;
 *             }
 *         }
 *
 *         return count;
 *     }
 *
 *
 *     public class QuickUnionFind {
 *         public int[] parent;
 *         public int[] size;
 *
 *         public QuickUnionFind(int n) {
 *             parent = new int[n];
 *             size = new int[n];
 *
 *             for(int i = 0; i < n; i ++) {
 *                 parent[i] = i;
 *                 size[i] = 1;
 *             }
 *         }
 *
 *         public int find(int id) {
 *             while(id != parent[id]) {
 *                 // path compression
 *                 parent[id] = parent[parent[id]];
 *                 id = parent[id];
 *             }
 *             return id;
 *         }
 *
 *         public void union(int i, int j) {
 *             int root1 = find(i);
 *             int root2 = find(j);
 *
 *             if(root1 == root2)return;
 *
 *             if(size[root1] <= size[root2]) {
 *                 parent[root1] = root2;
 *                 size[root2] += size[root1];
 *             }
 *             else {
 *                 parent[root2] = root1;
 *                 size[root1] += size[root2];
 *             }
 *         }
 *     }
 * } */

// one pass
public class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)return 0;

        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(board[i][j] == '.')continue;

                if(i > 0 && board[i - 1][j] == 'X')continue;
                if (j > 0 && board[i][j-1] == 'X') continue;

                count ++;
            }
        }
        return count;
    }
}
