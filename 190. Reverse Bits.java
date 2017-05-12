public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i ++){
            result += n & 1;
            n = n >> 1;
            // last bit must not shift
            if(i <= 30)result = result << 1;
        }
        return result;
    }
}
