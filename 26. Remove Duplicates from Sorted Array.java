public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return 1;

        int i = 0;
        int j = 1;

        for(; j < nums.length; j ++) {
            if(nums[j] != nums[i]) {
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
