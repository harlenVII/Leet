/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Comparator<Interval> com = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                // return i1.start == i2.start ? i1.start - i2.start : i1.end - i2.end;
                return i1.start - i2.start;
            }
        };
        Collections.sort(intervals, com);
        int i = 1;
        while (i < intervals.size()) {
            // merge i i-1
            if (intervals.get(i - 1).end >= intervals.get(i).start) {
                intervals.get(i - 1).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
                intervals.remove(i);
            } else {
                i++;
            }
        }
        return intervals;
    }
}
