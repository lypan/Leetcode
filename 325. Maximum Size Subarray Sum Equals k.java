public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {

        // key: accumulated sum, value: accumulated sum's index
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = 0;
        int sum = 0;

        // if there are zero, it will be replaced
        // else it means it is continuous at tht index 0
        map.put(0, -1);
        for(int i = 0; i < nums.length; i ++) {
            sum += nums[i];

            if(map.containsKey(sum - k))length = Math.max(length, i - map.get(sum - k));

            if(map.containsKey(sum))map.put(sum, Math.min(map.get(sum), i));
            else map.put(sum,  i);
        }

        return length;

    }
}
