public class Solution {
    public int arrangeCoins(int n) {
        if(n == 0)return 0;

        int sum = 0;
        // index start from 1, so we will add -1 in the end to range from 0
        int index = 1;

        while(n > 0) {
            n -= index;
            index ++;
        }

        // not equal, must move backward one more step
        if(n < 0)return (index - 1) - 1;
        // equal
        else return (index - 1);
    }
}

// sol2
// public class Solution {
//     public int arrangeCoins(int n) {
//         int start = 0;
//         int end = n;
//         int mid = 0;
//         while (start <= end){
//             mid = (start + end) >>> 1;
//             if ((0.5 * mid * mid + 0.5 * mid ) <= n){
//                 start = mid + 1;
//             }else{
//                 end = mid - 1;
//             }
//         }
//         return start - 1;
//     }
// }
