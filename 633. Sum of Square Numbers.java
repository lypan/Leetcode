public class Solution {
    public boolean judgeSquareSum(int c) {
        // zero is integer!!!
        for(long a = 0; a * a <= c; a ++) {
            int b = c - (int)(a * a);
            if(binary_search(0, b, b))return true;
        }
        return false;
    }
    public boolean binary_search(long lo, long hi, long target) {
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;

            if(mid * mid > target)hi = mid - 1;
            else if(mid * mid < target)lo = mid + 1;
            else return true;
        }
        if(lo * lo == target)return true;
        return false;
    }
}

// sol2
// public class Solution {
//     public boolean judgeSquareSum(int c) {
//         for (long a = 0; a * a <= c; a++) {
//             double b = Math.sqrt(c - a * a);
//             if (b == (int) b)
//                 return true;
//         }
//         return false;
//     }
// }
