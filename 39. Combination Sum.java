class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        backtrack(0, target, candidates, temp, result);
        return result;
    }
    private void backtrack(int start, int remain, int[] nums, List<Integer> tempList, List<List<Integer>> resultList) {
        if(remain < 0)return;
        if(remain == 0) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = start; i < nums.length; i ++) {
            tempList.add(nums[i]);
            backtrack(i, remain - nums[i], nums, tempList, resultList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
