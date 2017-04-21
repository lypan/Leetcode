public class Solution {
    public int numWays(int n, int k) {

        if(n == 0)return 0;
        else if(n == 1)return k;

        // for i = 0 and 1, that is after two units fences, how many color combination counts
        // the total count is made up by the current different or same the before one color
        // total = different + same
        // take 3 color for 2 fences as the example to think
        // different:9, same: 3
        int differentColorCount = k * (k - 1);
        int sameColorCount = k * 1;

        for(int i = 2; i < n ; i ++) {
            // same or different as i - 1 index
            // if add one more fence, how many counts will change

            int temp = differentColorCount;
            differentColorCount = (differentColorCount + sameColorCount) * (k - 1);
            sameColorCount = temp * 1;
        }

        return differentColorCount + sameColorCount;
    }
}
