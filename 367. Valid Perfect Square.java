class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        long lo = 1, hi = num;// long type to avoid 2147483647 case
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if(mid  * mid > num)hi = mid - 1;
            else if(mid * mid < num)lo = mid + 1;
            else return true;
        }
        if(lo * lo == num)return true;

        return false;
    }
}
