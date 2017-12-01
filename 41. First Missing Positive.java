class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            // if value not put in correct position index, ex: 2 should be in index 1
            while(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] - 1 != i)return i + 1;
        }

        return nums.length + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
