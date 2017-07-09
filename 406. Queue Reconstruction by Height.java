public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,
                    (int[] a, int[] b) -> {
                        if(a[0] == b[0])return a[1] - b[1];
                        else return b[0] - a[0];
                    }
        );

        List<int[]> result = new LinkedList<>();

        for(int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[0][0]);
    }
}
