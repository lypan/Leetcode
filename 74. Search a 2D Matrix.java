class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return false;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int l = 0;
        int r = (matrix.length * matrix[0].length) - 1;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int mVal = matrix[m / colLen][m % colLen];

            if(mVal > target)r = m - 1;
            else if(mVal < target)l = m + 1;
            else return true;
        }

        return false;
    }
}
