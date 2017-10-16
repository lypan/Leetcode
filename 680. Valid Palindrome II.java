class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.isEmpty())return true;
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if(s.charAt(start) == s.charAt(end)){
                start ++;
                end --;
            }
            else {
                // should return result because only remove one character
                // check if remove start or end, is it valid?
                if(isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1))return true;
                else return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end){
            if(s.charAt(start) != s.charAt(end))return false;
            start ++;
            end --;
        }
        return true;
    }
}
