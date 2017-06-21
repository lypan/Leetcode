public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        if(timeSeries == null || timeSeries.length == 0)return result;

        // i = 0
        result += duration;
        for(int i = 1; i < timeSeries.length; i ++) {
            if(timeSeries[i] <= (timeSeries[i - 1] + duration - 1)) {
                result += (timeSeries[i] + duration - 1) - (timeSeries[i - 1] + duration - 1);
            }
            else {
              result += duration;
            }
        }

        return result;
    }
}
