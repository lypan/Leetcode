class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)return result;
        String temp = "";
        // ex:"ab", 0 is a, b is 1
        int digitID = 0;
        backtrack(digitID, digits, temp, result);

        return result;
    }

    private void backtrack(int digitID, String digits, String temp, List<String> result) {
        if(temp.length() == digits.length()) {
            result.add(temp);
            return;
        }

        // base digitID to select group
        String letters = KEYS[digits.charAt(digitID) - '0'];
        for(int i = 0; i < letters.length(); i ++) {
            // since string is immutable, it will create new one when modified
            backtrack(digitID + 1, digits, temp + letters.charAt(i), result);
        }
    }
}
