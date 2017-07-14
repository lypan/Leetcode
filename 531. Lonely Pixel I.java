public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int result = 0;

        int[] rowCounts = new int[picture.length];
        int[] colCounts = new int[picture[0].length];

        // pass1 : construct row & col count
        for(int i = 0; i < picture.length; i ++) {
            for(int j = 0; j < picture[0].length; j ++) {
                if(picture[i][j] == 'B') {
                    rowCounts[i] ++;
                    colCounts[j] ++;
                }
            }
        }

        // pass2 : calculate numbers
        for(int i = 0; i < picture.length; i ++) {
            for(int j = 0; j < picture[0].length; j ++) {
                if(picture[i][j] == 'B' && rowCounts[i] == 1 && colCounts[j] == 1) {
                    result ++;
                }
            }
        }

        return result;
    }
}
