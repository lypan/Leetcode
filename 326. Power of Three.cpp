// // iterative version
// class Solution {
// public:
//     bool isPowerOfThree(int n) {
//         if(n > 1) {
//             while(n % 3 == 0) n /= 3;
//         }
//         return n==1;
//     }
// };
// recursive version
// class Solution {
// public:
//     bool isPowerOfThree(int n) {
//         if(n == 0)return false;
//         else if(n == 1)return true;
//         else return !(n % 3) && isPowerOfThree(n / 3);
//     }
// };
// log version
class Solution {
public:
    bool isPowerOfThree(int n) {
        return fmod(log10(n)/log10(3), 1)==0;
    }
};
