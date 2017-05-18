public class Solution {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for(Integer val : nums) {
            // avoid duplicate number
            if(val.equals(first) || val.equals(second) || val.equals(third))continue;

            if(first == null || val > first) {
                third = second;
                second = first;
                first = val;
            }
            else if(second == null || val > second) {
                third = second;
                second = val;
            }
            else if(third == null || val > third) {
                third = val;
            }
        }

        return (third == null) ? first : third;

    }
}
