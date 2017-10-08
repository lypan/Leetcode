class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(1, temp, result, n, k);
        return result;
    }

    private void backtrack(int start, List<Integer> tempList, List<List<Integer>> resultList, int n, int k) {
        if(tempList.size() == k) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = start; i <= n; i ++) {
            tempList.add(i);
            backtrack(i + 1, tempList, resultList, n, k);
            tempList.remove(tempList.size() - 1);
        }
    }

}
