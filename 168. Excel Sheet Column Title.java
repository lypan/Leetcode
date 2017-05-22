public class Solution {
    public String convertToTitle(int n) {
        String result = "";

        while(n > 0) {
            n --;
            char ch = (char)('A' + (n % 26));
            n /= 26;
            result = Character.toString(ch) + result;
        }

        return result;
    }
}
