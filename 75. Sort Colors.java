public class Solution {

    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;

        for(int i = 0; i <= blue; i ++) {
            if(nums[i] == 0) {
                swap(nums, red, i);
                red ++;
            }
            else if(nums[i] == 2) {
                swap(nums, blue, i);
                // check the swapped element, it may be anything
                i --;
                blue --;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
