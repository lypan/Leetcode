public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // the algorithm is set bag needed to be carry
        // imagine set one bay to carry from start to end
        // sum will be the path which the bag's weight walk along
        // start index is bag weight, and end index is minus bag weight to put it off
        int[] bagToCarry = new int[length];

        for(int[] op : updates) {
            int start = op[0];
            int end = op[1];
            int weight = op[2];

            bagToCarry[start] += weight;
            
            if(end < length - 1)bagToCarry[end + 1] += -weight;
        }

        int accumulatedWeight = 0;
        for(int i = 0; i < length; i ++) {
            accumulatedWeight += bagToCarry[i];
            bagToCarry[i] = accumulatedWeight;
        }

        return bagToCarry;
    }
}
