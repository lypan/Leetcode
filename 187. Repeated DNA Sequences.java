class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> characterMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        characterMap.put('A', 0);
        characterMap.put('C', 1);
        characterMap.put('G', 2);
        characterMap.put('T', 3);

        Integer key = 0;
        for(int i = 0; i <= s.length() - 10; i ++) {
            key = 0;
            for(int j = i; j < i + 10; j ++) {
                Character ch = s.charAt(j);
                key <<= 2;
                key |= characterMap.get(ch);
            }
            if(firstSet.contains(key)) {
                // avoid add multiple string to result
                if(!secondSet.contains(key))result.add(s.substring(i, i + 10));
                secondSet.add(key);
            }
            firstSet.add(key);
        }
        return result;
    }
}
