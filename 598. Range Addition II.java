public class Solution {
    public int maxCount(int m, int n, int[][] ops) {

        if(ops == null || ops.length == 0)return m * n;

        int min_row = Integer.MAX_VALUE;
        int min_col = Integer.MAX_VALUE;

        for(int[] op : ops) {
            min_row = Math.min(min_row, op[0]);
            min_col = Math.min(min_col, op[1]);
        }

        return min_row* min_col;
    }
}
