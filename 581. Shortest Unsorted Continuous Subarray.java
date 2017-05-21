public class Solution {
    public int findUnsortedSubarray(int[] nums) {

        // if(nums == null || nums.length == 0)return 0;
        // else if(nums.length == 1)return 1;

        boolean isFalling = false;
        boolean isRising = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // assume len >= 2
        // find min from left
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] < nums[i - 1])isFalling = true;
            else if(nums[i] >= nums[i - 1])isFalling = false;

            if(isFalling) min = Math.min(min, nums[i]);
        }
        // find max from right
        for(int i = nums.length - 1; i >= 1; i --) {
            if(nums[i - 1] > nums[i])isRising = true;
            else if(nums[i - 1] <= nums[i])isRising = false;
            if(isRising) max = Math.max(max, nums[i - 1]);
        }

        int left = 0;
        int right = 0;
        // find leftest first element larger than min
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] > min) {
                left = i;
                break;
            }
        }
        // find rightest first element less than max
        for(int i = nums.length - 1; i >= 0; i --) {
            if(nums[i] < max) {
                right = i;
                break;
            }
        }

        return (right - left) <= 0 ? 0 : right - left + 1;
    }
}

// reference:https://www.wikiwand.com/en/Sieve_of_Eratosthenes
