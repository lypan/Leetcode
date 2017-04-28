public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i ++) {
            Character ch1 = s.charAt(i);
            Character ch2 = t.charAt(i);

            if(map1.get(ch1) == null && map2.get(ch2) != null)return false;
            else if(map1.get(ch1) != null && map2.get(ch2) == null)return false;
            else if(map1.get(ch1) != null && map2.get(ch2) != null && map1.get(ch1).intValue() != map2.get(ch2).intValue())return false;

            map1.put(ch1, i);
            map2.put(ch2, i);
        }
        return true;
    }
}
