class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)return -1;
        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target)return mid;
            else if(nums[mid] < nums[hi]) {
                if(target > nums[mid] && target <= nums[hi])lo = mid + 1;
                else hi = mid - 1;
            }
            else if(nums[mid] > nums[hi]) {
                if(target >= nums[lo] && target < nums[mid])hi = mid - 1;
                else lo = mid + 1;
            }
        }

        if(nums[lo] == target)return lo;
        return -1;
    }
}
