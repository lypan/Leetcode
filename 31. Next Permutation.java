class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)return;

        // if it is the current max, it will be increasing from right, ex:54321
        // try to find first decrease from right, ex:53421, 4 and 3 is decreasing
        int i = nums.length - 1;
        while(i > 0) {
            if(nums[i] > nums[i - 1])break;
            i --;
        }

        // current max, ex:54321
        if(i == 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // find the element to be swapped
        // becaise i is the first decreasing from right, index > i from right must be increasing
        i --;
        int j = nums.length - 1;
        while(j > i) {
            if(nums[j] > nums[i])break;
            j --;
        }
        swap(nums, i, j);

        // to get minimum increase, reverse the rest from right to decreasing
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while(i < j){
            swap(nums, i, j);
            i ++;
            j --;
        }
    }
}
