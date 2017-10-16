class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0)return 0;

        // because if larger one element, result & count minimum are 1
        int result = 1;
        int count = 1;
        for(int i = 0; i < nums.length; i ++) {
            if(i > 0 && nums[i - 1] < nums[i]){
                count ++;
                result = Math.max(result, count);
            }
            else count = 1;
        }
        return result;
    }
}
