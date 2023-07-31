// link -> https://leetcode.com/problems/insert-interval/
// insert the new interval such that intervals is still sorted
/*
Approach :
1.create a res arrayList and add intervals to it
2.firstly add all those intervals who are not merging with the interval i.e last of prev interval is less then 
the st. point of interval.
3.now start merging now we will grow intervals who are overlapping st point will be minimum of st point of intvl
and end point will be max of the end point of the interval
            i    i      i
 intv -> [[1,2],[3,5],[6,7]]  new -> [4,8]
 res ->  [[1,2],[3,5,[6,7]]] -> [[1,2],[3,8],[6,7]] -> [[1,2],[3,8]]
*/

//code:
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        //before merging
        while(i < intervals.length && intervals[i][1] < newInterval[0] ) {
            res.add(intervals[i]);
            i++;
        }
        // start merging
        int[] interval = newInterval;
        while(i < intervals.length && intervals[i][0] <= interval[1]) {
            interval[0] = Math.min(intervals[i][0],interval[0]);
            interval[1] = Math.max(intervals[i][1],interval[1]);
            i++;
        }
        res.add(interval);
        //remaining after merging
        while(i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}