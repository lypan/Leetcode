public class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);

        reverse(nums, k % nums.length, nums.length - 1);
        reverse(nums, 0, k % nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while(start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start ++;
            end --;
        }
    }
}
// sol2
// public class Solution {
//     public void rotate(int[] nums, int k) {
//         k = k % nums.length;
//         int[]  result = new int[nums.length];
//
//         for(int i = 0; i < nums.length; i ++) {
//             result[(i + k) % nums.length] = nums[i];
//         }
//
//         System.arraycopy(result, 0, nums, 0, nums.length);
//     }
// }
