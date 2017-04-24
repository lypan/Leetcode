public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for(int i = 0; i < nums.length; i +=2 ) {
            sum += nums[i];
        }

        return sum;
    }
}

// sol2
// public class Solution {
//     public int arrayPairSum(int[] nums) {
//
//         int[] arr = new int[20001];
//         int lim = 10000;
//
//         for (int num: nums)
//             arr[num + lim]++;
//
//         // leftOver means that there is one alone element in the left, so the pair isn't completed
//         // ex: [(2), 2], [(2), 2], (2), leftOver = true;
//         boolean leftOver = false;
//         int sum = 0;
//         for (int i = -10000; i <= 10000; i++) {
//             int index = i + lim;
//             // even
//             if(arr[index] % 2 == 0){
//                 if(leftOver) {
//                     leftOver = true;
//                     sum += (arr[index] / 2) * i;
//
//                 }
//                 else {
//                     leftOver = false;
//                     sum += (arr[index] / 2) * i;
//
//                 }
//             }
//             // odd
//             else if(arr[index] % 2 == 1){
//                 if(leftOver) {
//                     leftOver = false;
//                     sum += (arr[index] / 2) * i;
//
//                 }
//                 else {
//                     leftOver = true;
//                     sum += ((arr[index] + 1) / 2) * i;
//                 }
//             }
//         }
//
//         return sum;
//     }
// }
