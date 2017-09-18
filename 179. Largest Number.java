class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)return "";

        String[] strs = new String[nums.length];
        String result = "";
        for(int i = 0; i < nums.length; i ++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (str1, str2)->{
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            // large lexical value first, so do reverse
            return s2.compareTo(s1);
        });

        // special case: all zeros
        if(strs[0].equals("0"))return "0";

        // concatenate string
        for(String str : strs) {
            result += str;
        }

        return result;
    }
}
