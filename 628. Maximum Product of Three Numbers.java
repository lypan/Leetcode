public class Solution {
    public int maximumProduct(int[] nums) {
        if(nums == null || nums.length == 0)return 0;

        int length = nums.length;
        Arrays.sort(nums);
        int candidate1 = nums[length - 1] * nums[length - 2] * nums[length - 3];
        int candidate2 = nums[0] * nums[1] * nums[length - 1];

        return Math.max(candidate1, candidate2);
    }
}
// sol2
// public class Solution {
//     public int maximumProduct(int[] nums) {
//         if(nums == null || nums.length == 0)return 0;
//
//         int min1 = Integer.MAX_VALUE;
//         int min2 = Integer.MAX_VALUE;
//         int max1 = Integer.MIN_VALUE;
//         int max2 = Integer.MIN_VALUE;
//         int max3 = Integer.MIN_VALUE;
//
//
//         for(int n : nums) {
//             if(n < min1) { // < min1
//                 min2 = min1;
//                 min1 = n;
//             }
//             else if(n < min2) { // > min1 && < min2
//                 min2 = n;
//             }
//
//             if(n > max1) { // > max1
//                 max3 = max2;
//                 max2 = max1;
//                 max1 = n;
//             }
//             else if(n > max2) { // > max2 && < max1
//                 max3 = max2;
//                 max2 = n;
//             }
//             else if(n > max3) { // > max3 && < max2
//                 max3 = n;
//             }
//         }
//
//         return Math.max(max1 * max2 * max3, min1 * min2 * max1);
//     }
// }
