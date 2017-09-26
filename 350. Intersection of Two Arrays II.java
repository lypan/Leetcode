class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> intersect = new ArrayList<Integer>();

        for(int val : nums1) {
            if(!map.containsKey(val))map.put(val, 1);
            else map.put(val, map.get(val) + 1);
        }

        for(int val : nums2) {
            if(map.containsKey(val) && map.get(val) > 0) {
                intersect.add(val);
                map.put(val, map.get(val) - 1);
            }
        }

        int[] result = new int[intersect.size()];
        int i = 0;
        for(int val : intersect) {
            result[i ++] = val;
        }

        return result;
    }
}
