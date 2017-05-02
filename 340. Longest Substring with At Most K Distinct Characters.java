public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int count = 0;
        int start = 0;
        int end = 0;
        int maxLen = 0;

        int[] map = new int[256];

        while(end < s.length()) {
            char ch = s.charAt(end);
            end ++;

            if(map[ch] == 0)count ++;
            map[ch] ++;

            while(count == k + 1) {
                ch = s.charAt(start);
                map[ch] --;

                if(map[ch] == 0)count --;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);

        }

        return maxLen;
    }
}
