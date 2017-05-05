public class Solution {
    public boolean wordPattern(String pattern, String str) {
        // pattern and str should be only 1 to 1
        // ex: a->dog & dog->a
        // so we use two map to check its dependency
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();

        String[] strArray = str.split(" ");

        if(strArray.length != pattern.length())return false;

        int i = 0;
        for(Character ch : pattern.toCharArray()) {
            String s = strArray[i];
            i ++;

            if(map.get(ch) == null && reverseMap.get(s) == null){
                map.put(ch, s);
                reverseMap.put(s, ch);
            }
            else if(map.get(ch) != null && Objects.equals(map.get(ch), s) && reverseMap.get(s) != null && Objects.equals(reverseMap.get(s), ch))continue;
            else return false;
        }

        return true;
    }
}
