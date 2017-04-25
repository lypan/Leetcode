public class Solution {
    public String countAndSay(int n) {
        String number = "1";

        String result = "";
        if(n <= 1)return number;

        for(int i = 1; i < n; i ++) {
            String temp = "";
            for(int j = 0; j < number.length(); j ++) {
                // each character occur at least one
                int count = 1;
                while(j + 1 < number.length() && number.charAt(j) == number.charAt(j + 1)) {
                    count ++;
                    j ++;
                }
                temp += (String.valueOf(count) + number.charAt(j));
            }
            number = temp;
        }
        return number;
    }
}
