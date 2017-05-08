public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permutationHelper(nums, visited, tempList, result);
        return result;
    }

    private void permutationHelper(int[] nums, boolean[] visited, List<Integer> tempList, List<List<Integer>> result) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<Integer>(tempList));
            return;
        }

        int temp;
        for(int i = 0; i < nums.length; i ++) {

            if(visited[i] == true)continue;
            if(i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == false)continue;
            /*
                上面这一连串判断条件，重点在于要能理解!used(i-1)
                要理解这个，首先要明白i作为数组内序号，i是唯一的
                给出一个排好序的数组，[1,2,2]
                第一层递归            第二层递归            第三层递归
                [1]                    [1,2]                [1,2,2]
                序号:[0]                 [0,1]            [0,1,2]
                这种都是OK的，但当第二层递归i扫到的是第二个"2"，情况就不一样了
                [1]                    [1,2]                [1,2,2]
                序号:[0]                [0,2]                [0,2,1]
                所以这边判断的时候!used(0)就变成了true，不会再继续递归下去，跳出循环
                步主要就是为了去除连续重复存在的

                會重複的話，主要原因是相同的元素前後順序沒有固定
                如果第一個2永遠在第二個2的前面，所產生的排列就不會有重複
            */
            visited[i] = true;
            tempList.add(nums[i]);
            permutationHelper(nums, visited, tempList, result);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
        return;
    }

}

// sol2
// public class Solution {
//     public List<List<Integer>> permuteUnique(int[] nums) {
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
//
//             // ensure that won't swaps duplicate elements
//             // will only swap the first duplicate element to ensure the order sequence
//             if(hasDuplicate(nums, leftIdx, i))continue;
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
//
//     private boolean hasDuplicate(int[] num, int start, int end) {
//         for(int i=start; i<end; i++) {
//             if(num[i] == num[end]) return true;
//         }
//         return false;
//     }
// }
