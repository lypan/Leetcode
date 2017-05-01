public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        if(m * n != r * c)return nums;

        int index_1D = 0;

        int[][] result = new int[r][c];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                result[index_1D / c][index_1D % c] = nums[i][j];
                index_1D ++;
            }
        }

        return result;
    }
}
// sol2
// public class Solution {
//     public int[][] matrixReshape(int[][] nums, int r, int c) {
//         int m = nums.length;
//         int n = nums[0].length;
//
//         if(m * n != r * c)return nums;
//
//         int r_idx = 0;
//         int c_idx = 0;
//
//         int[][] result = new int[r][c];
//         for(int i = 0; i < m; i ++) {
//             for(int j = 0; j < n; j ++) {
//                 result[r_idx][c_idx] = nums[i][j];
//
//                 c_idx ++;
//
//                 if(c_idx == c) {
//                     c_idx = 0;
//                     r_idx ++;
//                 }
//             }
//         }
//
//         return result;
//     }
// }
