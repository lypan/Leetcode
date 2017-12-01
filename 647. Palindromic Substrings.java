class Solution {
    private int count = 0;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)return 0;

        for(int i = 0; i < s.length(); i ++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void extendPalindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count ++;
            i --;
            j ++;
        }
    }
}
