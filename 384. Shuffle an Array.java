public class Solution {
    private int[] originalArray;
    private int[] shuffleArray;
    public Solution(int[] nums) {
        originalArray = Arrays.copyOf(nums, nums.length);
        shuffleArray = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffleArray = Arrays.copyOf(originalArray, originalArray.length);
        return shuffleArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int shuffleLength = shuffleArray.length;
        int lastIndex = shuffleLength - 1;
        for(int i = 0; i < shuffleArray.length; i ++) {
            Random random = new Random();
            int shuffleIndex = random.nextInt(shuffleLength);
            swap(shuffleArray, shuffleIndex, lastIndex);
            lastIndex --;
            shuffleLength --;
        }
        return shuffleArray;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
