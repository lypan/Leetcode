public class Solution {
    public boolean checkRecord(String s) {
        int count_A = 0;
        int count_L = 0;
        for(int i = 0; i < s.length();i ++) {
            if(s.charAt(i) == 'A') {
                count_A ++;
                count_L = 0;
            }
            else if(s.charAt(i) == 'L')count_L ++;
            else count_L = 0;

            if(count_A >= 2 || count_L >= 3)return false;
        }
        return true;
    }
}

// sol2
// public class Solution {
//     public boolean checkRecord(String s) {
//         return !s.matches(".*(A.*A|LLL).*");
//     }
// }
