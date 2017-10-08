class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // sort array so it can search
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i ++) {

            // if the fixed element is fixed before continue
            if(i != 0 && (i > 0 && nums[i] == nums[i-1]))continue;
            // fixed one element : nums[i]
            int sum = 0 - nums[i];

            int l = i + 1;
            int r = nums.length - 1;

            while(l < r) {
                if(nums[l] + nums[r] == sum) {
                    result.add(new ArrayList(Arrays.asList(nums[i], nums[l], nums[r])));
                    // move to duplicate elements' boundary
                    while(l < r && nums[l] == nums[l + 1])l ++;
                    while(l < r && nums[r] == nums[r - 1])r --;
                    // move to the next new element
                    l ++;
                    r --;
                }
                else if(nums[l] + nums[r] < sum)l ++;
                else if(nums[l] + nums[r] > sum)r --;
            }
        }
        return result;
    }
}
