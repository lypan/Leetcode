class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null)return;

        boolean row0 = false;
        boolean col0 = false;

        // set state
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                if(matrix[i][j] == 0) {
                    if(i == 0)row0 = true;
                    if(j == 0)col0 = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // fill zeros
        // the first row and col should only be determined by rwo0, col0
        for(int i = 1; i < matrix.length; i ++) {
            for(int j = 1; j < matrix[0].length; j ++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // row0 & col0
        if(row0) {
            for(int j = 0; j < matrix[0].length; j ++) {
                matrix[0][j] = 0;
            }
        }
        if(col0) {
            for(int i = 0; i < matrix.length; i ++) {
                matrix[i][0] = 0;
            }
        }
    }
}
