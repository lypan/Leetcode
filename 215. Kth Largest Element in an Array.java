public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return rSelect(nums, 0, nums.length - 1, k);
    }

    int rSelect(int[] nums, int start, int end, int k) {
        int pivotIndex = randomPartition(nums, start, end);
        // transform relative k to absolute k index
        int kIndex = start + k - 1;

        if(pivotIndex == kIndex)return nums[pivotIndex];
        else if(pivotIndex > kIndex)return rSelect(nums, start, pivotIndex - 1, k);
        else /*if(pivotIndex < kIndex)*/return rSelect(nums, pivotIndex + 1, end, kIndex - pivotIndex);
    }

    int randomPartition(int[] nums, int start, int end) {
        // only one element
        if(start == end) return start;

        Random rand = new Random();
        int pivotIdx = rand.nextInt(end - start) + start;
        int pivotVal = nums[pivotIdx];
        // swap start element with pivot
        swap(nums, start, pivotIdx);
        // arrange elements to 3 parts
        // pivot, less than pivot, larger than pivot
        int i = start + 1;
        for(int j = start + 1; j <= end; j ++) {
            if(nums[j] >= pivotVal) {
                swap(nums, i, j);
                i ++;
            }
        }
        i --;
        // swap pivot to correct position
        swap(nums, start, i);
        // return pivot real index in order
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
