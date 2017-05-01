public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(s == null || p == null)return result;

        int[] map = new int[256];
        int left = 0;
        int right = 0;
        int count = p.length();

        for(char ch : p.toCharArray())map[ch] ++;

        while(right < s.length()) {
            char ch = s.charAt(right);
            right ++;

            // ch is in the p
            if(map[ch] > 0)count --;
            // any char not in p will be -1
            map[ch] --;

            if(count == 0)result.add(left);

            // move left one unit foward and adjusts the map
            if(right - left == p.length()) {
                ch = s.charAt(left);
                // ch is in the p
                if(map[ch] >= 0)count ++;

                map[ch] ++;
                left ++;
            }
        }

        return result;

    }
}
