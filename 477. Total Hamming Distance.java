public class Solution {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int[] table = new int[32];

        // pass 1:record each bit 1's number
        for(int i = 0; i < nums.length; i ++) {
            int val = nums[i];
            for(int j = 0; j < 32; j ++) {
                if((nums[i] & 1) == 1) table[j] ++;
                nums[i] >>= 1;
            }
        }

        // pass 2:accmuluate 1's number * 0's number
        int result = 0;
        for(int i = 0; i < 32; i ++)result += table[i] * (nums.length - table[i]);

        return result;
    }
}
