public class Solution {
    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int low, int high) {

        while(low < high) {
            int middle = low + (high - low) / 2;

            int right = (middle + 1 >= nums.length) ? nums.length - 1 : middle + 1;
            int left = (middle - 1 <= 0) ? 0 : middle - 1;

            if(nums[middle] != nums[left] && nums[middle] != nums[right])return nums[middle];
            else if(nums[middle] == nums[left] && middle % 2 == 1 || nums[middle] == nums[right] && middle % 2 == 0)low = middle + 1;
            else high = middle - 1;
        }

        return nums[low];
    }
}
