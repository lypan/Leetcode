public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0) {
            one += (n & 1);
            n >>>= 1;
        }
        return ones;
    }
}
