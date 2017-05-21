public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while(i < word.length() && j < abbr.length()) {
            // skip the same characters
            if(word.charAt(i) == abbr.charAt(j)) {
                i ++;
                j ++;
                continue;
            }
            else if(!Character.isDigit(abbr.charAt(j)))return false;
            // get abbr number
            int number = 0;
            while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                number *= 10;
                number += abbr.charAt(j) - '0';
                // avoid number such as "0XXXX"
                if(number == 0)return false;
                j ++;
            }
            // move i number units
            i += number;
        }
        return i == word.length() && j == abbr.length();
    }
}
