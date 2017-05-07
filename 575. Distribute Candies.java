public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();

        for(Integer val : candies)set.add(val);

        return Math.min(set.size(), candies.length / 2);
    }
}
