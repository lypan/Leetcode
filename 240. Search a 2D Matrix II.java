class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return false;

        // start from top right corner's value
        // if > value, next bottom row
        // if < value, next left col

        int rowIdx = 0;
        int colIdx = matrix[0].length - 1;

        int value = matrix[rowIdx][colIdx];

        while(colIdx >= 0 && rowIdx <= matrix.length - 1) {
            value = matrix[rowIdx][colIdx];
            if(value == target)return true;
            else if(value < target)rowIdx ++;
            else if(value > target)colIdx --;
        }

        return false;
    }
}
