class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix == null || matrix.length == 0)return result;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while(true) {
            // right
            for(int i = colBegin; i <= colEnd; i ++)result.add(matrix[rowBegin][i]);
            rowBegin ++;
            if(rowBegin > rowEnd)break;
            // down
            for(int i = rowBegin; i <= rowEnd; i ++)result.add(matrix[i][colEnd]);
            colEnd --;
            if(colBegin > colEnd)break;
            // left
            for(int i = colEnd; i >= colBegin; i --)result.add(matrix[rowEnd][i]);
            rowEnd --;
            if(rowBegin > rowEnd)break;
            // up
            for(int i = rowEnd; i >= rowBegin; i --)result.add(matrix[i][colBegin]);
            colBegin ++;
            if(colBegin > colEnd)break;

        }

        return result;
    }
}
