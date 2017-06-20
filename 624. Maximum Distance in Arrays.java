public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // get first array's min & max
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int distance = Integer.MIN_VALUE;

        // calculate distance for each array's min & max
        for(int i = 1; i < arrays.size(); i ++) {
            int d1 = Math.abs(min - arrays.get(i).get(arrays.get(i).size() - 1));
            int d2 = Math.abs(max - arrays.get(i).get(0));
            int d3 = Math.max(d1, d2);

            distance = Math.max(distance, d3);

            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }

        return distance;
    }
}
