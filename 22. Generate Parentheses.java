class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        generateResult(0, 0, n, "", resultList);
        return resultList;
    }

    void generateResult(int open, int close, int max, String result, List<String> list) {
        if(result.length() == max * 2) {
            list.add(result);
            return;
        }

        // open first
        if(open < max) {
            generateResult(open + 1, close, max, result + "(", list);
        }
        // backtrack here!!!
        // add close only if open > close
        if(open > close) {
            generateResult(open, close + 1, max, result + ")", list);
        }

    }
}
