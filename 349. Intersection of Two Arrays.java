class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for(int val : nums1) {
            set.add(val);
        }

        for(int val : nums2) {
            if(set.contains(val))intersect.add(val);
        }

        int[] result = new int[intersect.size()];

        int i = 0;
        for(int val : intersect) {
            result[i ++] = val;
        }

        return result;
    }
}
