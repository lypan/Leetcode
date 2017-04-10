public class Solution {
    public int countSegments(String s) {

        int count = 0;

        for(int i = 0; i < s.length(); i ++) {
            if(!Character.isWhitespace(s.charAt(i)) && (i == 0 || Character.isWhitespace(s.charAt(i - 1)))) {
                // 1.i == 0 use or short circuit, so won't happen index out of range
                // 2.only count when enter a new word
                count ++;
            }
        }

        return count;
     }
}
