public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)return new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String key = String.valueOf(charArray);

            if(!map.containsKey(key))map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
