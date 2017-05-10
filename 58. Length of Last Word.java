public class Solution {
    public int lengthOfLastWord(String s) {
        // start from the end to calculate the last word length
        int right = s.length() - 1;

        while(right >= 0 && s.charAt(right) == ' ') right --;
        int left = right;

        while(left >= 0 && s.charAt(left) != ' ') left --;

        return right - left;
    }
}
