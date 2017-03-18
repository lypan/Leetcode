class Solution {
public:
    int hammingDistance(int x, int y) {
        // sol1
        int count = 0;
        int temp = x ^ y;
        while( temp ) {
            temp &= temp - 1;
            count ++;
        }
        return count;
        
        // sol2
        // int v = x ^ y;
        // v = v - ((v>>1) & 0x55555555);
        // v = (v & 0x33333333) + ((v>>2) & 0x33333333);
        // return ((v + (v>>4) & 0xF0F0F0F) * 0x1010101) >> 24;
        // sol3
        // return __builtin_popcount (x ^ y);
        
        // reference1:http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
        // reference2:http://stackoverflow.com/questions/14555607/explanation-required-number-of-bits-set-in-a-number
    }
};
