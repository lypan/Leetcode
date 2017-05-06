public class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i ++){
            // map to 0 ~ len - 1
            // because nums value may be negative
            int index = Math.abs(nums[i]) - 1;
            int value = nums[index];
            // because number is range only from 1 ~ len, all are positive numbers
            // when we see a positive number, we set it to negative, meanings we have seen it
            if(value > 0) nums[index] = - nums[index];
            // netagive means we have already see it before == duplicate
            else if(value < 0)result.add(Math.abs(nums[i]));
        }

        return result;
    }
}
