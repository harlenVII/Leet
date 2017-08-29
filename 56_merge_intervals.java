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
        if (intervals == null || intervals.size() == 0)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= intervals.get(i - 1).end) {
                intervals.get(i - 1).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }
}
