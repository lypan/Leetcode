public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0)return 0;

        Map<Integer, Integer> map = new HashMap<>();
        // pass 1:construct map, key:value, value:exist or not
        for(int num : nums)map.put(num, map.getOrDefault(num, 0) + 1);
        // pass 2:
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(k == 0) {
                if(entry.getValue() >= 2)count ++
            }
            else {
                if(map.containsKey(entry.getKey() + k)count ++;
            }
        }

        return count;
    }
}
