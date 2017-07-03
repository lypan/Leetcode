public class Solution {
    public String findContestMatch(int n) {
        List<String> matches = new ArrayList<>();

        for(int i = 1; i <= n; i ++)matches.add(Integer.toString(i));

        while(n > 1) {
            for(int i = 0; i < n / 2; i ++) {
                String str = "(" + matches.get(i) + "," + matches.get(n - 1 - i) + ")";
                matches.set(i, str);
            }

            n /= 2;
        }

        return matches.get(0);
    }
}
