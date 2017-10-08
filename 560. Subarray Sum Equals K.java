class Solution {
    public int subarraySum(int[] nums, int k) {
      // key: accumulated sum, value: accumulated count
        int preSum = 0;
        int count = 0;

        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);

        for(int n : nums) {
            preSum += n;
            if(preSumMap.containsKey(preSum - k)) {
                count += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
