/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start - b.start);

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) return false;
        }

        return true;



    }
}
/*

sort them from smaller to greater, then compare the end time of and index and the start time of the next index
For Medium problems, it’s mainly those 2 types:

Merge/overlap → sort by start, compare neighbors
Count at the same time → sort, track ends with a heap


Merge/overlap. The answer is a list of intervals, or a yes/no about overlaps.

“merge them”
“insert this one”
“remove the fewest to avoid overlap”

Count at the same time. The answer is a number of things happening at once.

“how many rooms do we need”
“is the car ever over capacity”
“max people at the same time”

Quick test: ask yourself, “Do I care about the intervals themselves, or about how crowded it gets?”

The intervals themselves → merge
How crowded → heap
*/