class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;

        for(int n : nums)set.add(n);

        for(int n : nums) {
            if(!set.contains(n))continue;

            int length = 1;
            int left = n - 1;
            int right = n + 1;

            // left check
            while(set.contains(left)) {
                length ++;
                // remove element to avoid duplicate accumulation
                set.remove(left);
                left --;
            }

            // right check
            while(set.contains(right)) {
                length ++;
                // remove element to avoid duplicate accumulation
                set.remove(right);
                right ++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
