public class Solution {
    private int maxLen = 0;
    private int start = 0;
    private int end = 0;
    public String longestPalindrome(String s) {

        for(int i = 0; i < s.length() - 1; i ++) {
            int oddLen = expandFromCenter(s, i, i);
            int evenLen = expandFromCenter(s, i, i + 1);

            int len = Math.max(oddLen, evenLen);

            if(len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
                end = start + len - 1;
            }

        }
        return s.substring(start, end + 1);
    }

    public int expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        return right - left - 1;
    }
}

// sol2
// public class Solution {
//
//     public String longestPalindrome(String s) {
//
//         String result = "";
//         boolean[][] dp = new boolean[s.length()][s.length()];
//
//         for(int i = s.length() - 1; i >= 0; i --) {
//             for(int j = i; j < s.length(); j ++) {
//                 if(s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
//                     dp[i][j] = true;
//
//                     if(result == "" || j - i + 1 > result.length()) {
//                         result = s.substring(i, j + 1);
//                     }
//                 }
//             }
//         }
//
//         return result;
//     }
// }
