public class Solution {
    public int trailingZeroes(int n) {
        int five_num = 0;
        while(n > 0) {
            five_num += n / 5;
            n /= 5;
        }
        return five_num;
    }
}

// sol2
// public class Solution {
//     public int trailingZeroes(int n) {
//         if(n <= 0)return 0;
//         return n / 5 + trailingZeroes(n / 5);
//     }
// }
