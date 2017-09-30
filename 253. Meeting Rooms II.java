/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];

        for(int i = 0; i < len; i ++) {
            startTime[i] = intervals[i].start;
            endTime[i] = intervals[i].end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int roomSize = 0;
        int endIdx = 0;

        for(int start : startTime) {
            if(start < endTime[endIdx])roomSize ++;
            // >=, because when eauql, one must end and one must start
            else endIdx ++;
        }

        return roomSize;
    }
}
