public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)return "";

        int minLen = Integer.MAX_VALUE;
        String prefix = "";
        for(String s : strs) {
            if(s.length() < minLen) {
                prefix = s;
                minLen = s.length();
            }
        }


        for(int i = 0; i < prefix.length(); i ++) {
            char prefixCh = prefix.charAt(i);

            for(int j = 0; j < strs.length; j ++) {
                char strCh = strs[j].charAt(i);

                if(prefixCh != strCh)return prefix.substring(0, i);
            }
        }

        return prefix;
    }
}
