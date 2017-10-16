class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(0, nums, temp, result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> tempList, List<List<Integer>> resultList) {
        resultList.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i ++) {
            if(i > start && nums[i] == nums[i - 1])continue;
            tempList.add(nums[i]);
            backtrack(i + 1, nums, tempList, resultList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
