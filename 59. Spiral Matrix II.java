class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n == 0)return result;

        int num = 1;
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        while(true) {
            // right
            for(int i = colBegin; i <= colEnd; i ++)result[rowBegin][i] = num ++;
            rowBegin ++;
            if(rowBegin > rowEnd)break;
            // down
            for(int i = rowBegin; i <= rowEnd; i ++)result[i][colEnd] = num ++;
            colEnd --;
            if(colBegin > colEnd)break;
            // left
            for(int i = colEnd; i >= colBegin; i --)result[rowEnd][i] = num ++;
            rowEnd --;
            if(rowBegin > rowEnd)break;
            // up
            for(int i = rowEnd; i >= rowBegin; i --)result[i][colBegin] = num ++;
            colBegin ++;
            if(colBegin > colEnd)break;

        }

        return result;
    }
}
