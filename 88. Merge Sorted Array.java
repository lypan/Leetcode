public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i --;
            }
            else if(nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                j --;
            }
            k --;
        }

        // because we move nums2 to nums1, so the rest elements of nums1 are already sorted
        // we only have to check nums2 is empty or not
        while(j >= 0) {
            nums1[k] = nums2[j];
            j --;
            k --;
        }

    }
}
