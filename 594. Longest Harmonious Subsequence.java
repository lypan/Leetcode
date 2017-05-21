public class Solution {
    public int findLHS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // pass 1: construct map
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        // pass 2:key & key + 1,
        for(int num : nums) {
            if(map.containsKey(num + 1))maxLen = Math.max(maxLen, map.get(num) + map.get(num + 1));
        }

        return maxLen;
    }
}
