public class Solution {
    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int carry = 0;
        int sum = 0;
        String result = "";

        while(aIdx >= 0 || bIdx >= 0) {

            int n1 = aIdx >= 0 ? Character.getNumericValue(a.charAt(aIdx)): 0;
            aIdx --;
            int n2 = bIdx >= 0 ? Character.getNumericValue(b.charAt(bIdx)): 0;
            bIdx --;

            sum = carry ^ n1 ^ n2;
            carry = (n1 & n2) | (n1 & carry) | (n2 & carry);

            result = String.valueOf(sum) + result;
        }
        if(carry != 0)result = String.valueOf(carry) + result;

        return result;
    }
}
