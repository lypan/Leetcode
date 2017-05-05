public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // key:array[i], value:i
        for(int i = 0; i < nums.length; i ++) {
            int val = nums[i];

            if(map.get(val) == null)map.put(val, i);
            else if(i - map.get(val) <= k)return true;
            else map.put(val, i);
        }
        return false;
    }
}
