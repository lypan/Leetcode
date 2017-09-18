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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null)return result;
        if(intervals.size() <= 1)return intervals;

        // sort the interval by its starting time
        intervals.sort((interval1, interval2)->interval1.start - interval2.start);


        int start = intervals.get(0).start;
        int end = intervals.get(0).end;


        for(Interval interval : intervals) {
            // overlapping : keep expanding interval
            if(interval.start <= end) {
                end = Math.max(end, interval.end);
            }
            // disjoint : return last interval
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        result.add(new Interval(start, end));
        return result;
    }
}
