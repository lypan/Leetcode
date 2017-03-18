class Solution {
public:
    int findComplement(int num) {
        // sol1
        int temp = num;
        int multiSum = 1;
        while(temp) {
            temp /= 2;
            multiSum *= 2;
        }
        return (multiSum - 1) - num;
        // sol2
        // num          = 00000101
        // mask         = 11111000
        // ~mask & ~num = 00000010
        // unsigned int mask = ~0;
        // while( mask & num) mask <<= 1;
        // return ~mask & ~num;
    }
};
