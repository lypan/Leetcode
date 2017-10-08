// sol1
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, temp, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> resultList) {

        if(tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            // check for duplicate
            if(tempList.contains(nums[i]))continue;
            tempList.add(nums[i]);
            backtrack(nums, tempList, resultList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
// public class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//
//         permutationHelper(nums, 0, nums.length - 1, result);
//
//         return result;
//     }
//
//     private void permutationHelper(int[] nums, int leftIdx, int rightIdx, List<List<Integer>> result) {
//         if(leftIdx == rightIdx) {
//             List<Integer> list = new ArrayList<>();
//
//             for(int i = 0; i < nums.length; i ++)list.add(nums[i]);
//
//             result.add(list);
//             return;
//         }
//
//         int temp;
//         for(int i = leftIdx; i <= rightIdx; i ++) {
//             // swap foward
//             temp = nums[leftIdx];
//             nums[leftIdx] = nums[i];
//             nums[i] = temp;
//
//             permutationHelper(nums, leftIdx + 1, nums.length - 1, result);
//
//             // swap backward
//             temp = nums[leftIdx];
//             nums[leftIdx] = nums[i];
//             nums[i] = temp;
//         }
//         return;
//     }
// }
