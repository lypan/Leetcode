public class Solution {
    public int mySqrt(int x) {
        if(x == 0)return 0;
        return binarySearch(x);
    }
    int binarySearch(int n) {
        int left = 1;
        int right = n;

        while(left <= right){
            int middle = left + (right - left) / 2;

            if(middle == n / middle)return middle;
            else if(middle > n / middle)right = middle - 1;
            else if(middle < n / middle)left = middle + 1;
        }

        return right;
    }
}

// reference:http://bangbingsyb.blogspot.com/2014/11/leetcode-sqrtx.html
// reference:http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
