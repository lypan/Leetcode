public class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        for(int i = 0; i < 26; i ++)maxLen = Math.max(maxLen, longestSubStringWithUniqueChar(s, k, i + 1));
        return maxLen;
    }

    public int longestSubStringWithUniqueChar(String s, int k, int uniqueCharNumber) {

        int[] map = new int[256];
        int uniqueCharCount = 0;
        int noLessKCount = 0;
        int maxLen = 0;

        int start = 0;
        int end = 0;


        while(end < s.length()) {
            char ch = s.charAt(end);
            end ++;
            map[ch] ++;
            if(map[ch] == 1)uniqueCharCount ++;
            if(map[ch] == k)noLessKCount ++;

            while(uniqueCharCount > uniqueCharNumber) {
                ch = s.charAt(start);
                start ++;
                if(map[ch] == k)noLessKCount --;
                map[ch] --;
                if(map[ch] == 0)uniqueCharCount --;
            }

            if(uniqueCharCount == uniqueCharNumber && noLessKCount == uniqueCharNumber)maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
