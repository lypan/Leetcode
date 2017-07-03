public class Solution {
    public boolean judgeSquareSum(int c) {
        // zero is integer!!!
        for(long a = 0; a * a <= c; a ++) {
            int b = c - (int)(a * a);
            if(binary_search(0, b, b))return true;
        }
        return false;
    }
    public boolean binary_search(long low, long high, long target) {
        long middle = (low) + (high - low) / 2;
        if(low > high)return false;

        if(middle * middle == target)return true;
        else if(middle * middle > target) return binary_search(low, middle - 1, target);
    	return binary_search(middle + 1, high, target);
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
