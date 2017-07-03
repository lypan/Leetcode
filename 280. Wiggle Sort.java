public class Solution {
    public void wiggleSort(int[] nums) {
        // ascending order
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// sol2
// public class Solution {
//     public void wiggleSort(int[] nums) {
//         for(int i = 0; i < nums.length - 1; i ++) {

//             if(i % 2 == 0 && nums[i + 1] < nums[i] || i % 2 == 1 && nums[i + 1] > nums[i])
//             {
//                 swap(nums, i, i + 1);
//             }
//         }
//     }
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }
