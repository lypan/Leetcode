class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)return;
        // move non-zero first
        int index = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index ++;
            }
        }
        // fill zero
        while(index < nums.length){
            nums[index] = 0;
            index ++;
        }
    }
}
