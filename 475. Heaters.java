public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int maxRadius = Integer.MIN_VALUE;

        for(int housePos : houses) {
            int heaterIdx = Arrays.binarySearch(heaters, housePos);

            if(heaterIdx >= 0) {
                maxRadius = Math.max(maxRadius, 0);
                continue;
            }
            // not found, should add 1 and flip to be correct next "BIGGER" element's index
            else if(heaterIdx < 0) {
                heaterIdx = -(heaterIdx + 1);

                // compare the left and right heater to choose the closest heater
                // because min(left, right), so set MAX_VALUE as null value
                int leftDist = heaterIdx - 1 >= 0 ? Math.abs(housePos - heaters[heaterIdx - 1]) : Integer.MAX_VALUE;
                int rightDist = heaterIdx < heaters.length ? Math.abs(housePos - heaters[heaterIdx]) : Integer.MAX_VALUE;

                maxRadius = Math.max(maxRadius, Math.min(leftDist, rightDist));
            }
        }
        return maxRadius;
    }
}
// sol2
// public class Solution {
//     public int findRadius(int[] houses, int[] heaters) {
//         Arrays.sort(houses);
//         Arrays.sort(heaters);
//
//         int maxRadius = Integer.MIN_VALUE;
//         int j = 0;
//         for(int i = 0; i < houses.length; i ++) {
//             int housePosition = houses[i];
//             // find min house & heater position
//             // >= because some elements are repetitive, need to move on
//             while(j  + 1 < heaters.length && Math.abs(heaters[j] - housePosition) >= Math.abs(heaters[j + 1] - housePosition)) j ++;
//
//             int curMinRadius = Math.abs(heaters[j] - housePosition);
//             // find max radius that can barely cover all houses
//             maxRadius = Math.max(maxRadius, curMinRadius);
//         }
//         return maxRadius;
//     }
// }
