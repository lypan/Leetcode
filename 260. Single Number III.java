class Solution {
    public int[] singleNumber(int[] nums) {
        // 1. get A xor B
        int AxorB = 0;
        for(int n : nums)AxorB ^= n;
        // 2. divide into two group based on first different bit
        // because number appears twice will become 0 after xor
        int firstDifferentBit = AxorB & ~(AxorB - 1);

        int firstGroup = 0;
        int secondGroup = 0;
        for(int n : nums) {
            if((firstDifferentBit & n)!= 0) {
                firstGroup ^= n;
            }
            else {
                secondGroup ^= n;
            }
        }

        int[] result = {firstGroup, secondGroup};

        return result;
    }
}
