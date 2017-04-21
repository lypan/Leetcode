public class Solution {
    public boolean isPalindrome(int x) {
        // negative && excatly ten's mutplication
        if(x < 0 || x != 0 && x % 10 == 0)return false;

        int sum = 0;
        // eve: split number two half, odd: right has more one digit than left
        while(x > sum) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        // even: x == sum, odd:
        if(x == sum || sum / 10 == x)return true;
        else return false;
    }
}
