class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        int start = 0;
        int end = 0;
        int counter = t.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for(char ch : t.toCharArray())map.put(ch, map.getOrDefault(ch, 0) + 1);

        while(end < s.length()) {
            char ch1 = s.charAt(end);
            if(map.getOrDefault(ch1, 0) > 0)counter --;
            map.put(ch1, map.getOrDefault(ch1, 0) - 1);
            end ++;

            while(counter == 0) {
                if(end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                char ch2 = s.charAt(start);
                map.put(ch2, map.getOrDefault(ch2, 0) + 1);

                if(map.getOrDefault(ch2, 0) > 0)counter ++;
                start ++;
            }
        }

        if(minLen != Integer.MAX_VALUE)
            return s.substring(minStart, minStart + minLen);
        else return "";

    }
}
