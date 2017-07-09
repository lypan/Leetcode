public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder result = new StringBuilder("");
        if(nums == null || nums.length == 0)return result.toString();

        for(int i = 0; i < nums.length; i ++) {
            if(nums.length > 2 && i == 1)result.append("(");
            result.append(Integer.toString(nums[i]) + "/");
        }
        // remove last "/"
        result.deleteCharAt(result.length() - 1);
        // ex:[3,2] should be 3/2
        if(nums.length > 2)result.append(")");
        return result.toString();
    }
}
