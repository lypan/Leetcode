// log version
class Solution {
public:
    bool isPowerOfFour(int num) {
        return fmod(log10(num)/log10(4), 1)==0;
    }
};
// bit version
// class Solution {
// public:
//     bool isPowerOfFour(int num) {
//         return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
//     }
// };
