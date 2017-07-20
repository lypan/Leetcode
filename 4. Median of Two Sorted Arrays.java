public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = nums1.length + nums2.length;

        if(totalLen % 2 == 1) {
            return findKth(nums1, nums2, totalLen / 2 + 1);
        }
        else {
            return ( findKth(nums1, nums2, totalLen / 2) + findKth(nums1, nums2, totalLen / 2 + 1) ) / 2.0;
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        // always assume nums1 is the shorter array
        if(len1 > len2) {
            return findKth(nums2, nums1, k);
        }
        else if(len1 == 0) {
            return nums2[k - 1];
        }
        else if(k == 1) {
            return Math.min(nums1[0], nums2[0]);
        }

        int order1 = Math.min(len1, k / 2);
        int order2 = Math.min(len2, k / 2);

        if (nums1[order1 - 1] > nums2[order2 - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, order2, len2), k - order2);
        } else {
            return findKth(Arrays.copyOfRange(nums1, order1, len1), nums2, k - order1);
        }
    }
}
