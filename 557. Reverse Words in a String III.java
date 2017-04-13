
public class Solution {
    public String reverseWords(String s) {
        List<String> wordsList = new ArrayList<String>();
        String result = "";

        for(int i = 0; i < s.length(); i ++) {
            // split string
            if(Character.isWhitespace(s.charAt(i))) {
                wordsList.add(result);
                result = "";
            }
            // reverse string
            else {
                result = s.charAt(i) + result;
            }
        }
        // last string doesn't have whitespace afterwards
        wordsList.add(result);

        String concatedResult = "";

        for(String str : wordsList) {
            concatedResult += str + " ";
        }

        // remove the last whitespace
        return concatedResult.substring(0, concatedResult.length() - 1);
    }
}
