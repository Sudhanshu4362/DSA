// Link -> https://leetcode.com/problems/merge-intervals/
// merge all overlapping intervals
/*
Approach:
1.Sort the array on starting point of intervals
2.Maitain an arraylist first interval will be added directly but for next interval we check if starting point of 
next interval is less then the ending point of previous interval if yes we will merge the intervals and update
the ending point by max of ending point of intervals
                i     i     i      i
intervals -> [[1,3],[2,6],[8,10],[15,18]]
arraylist -> [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]] ->[[1,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
t(n) - nlogn
*/

// code
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            return a[0]- b[0];
        });
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) {
            if(list.size() == 0) {
                list.add(interval);
            } else {
                //get last interval from list
                int[] last = list.get(list.size() - 1);
                if(interval[0] > last[1]) {
                    //if next interval st. point > end of last ,no merging of interval
                    list.add(interval);
                } else {
                    // merging and updating end pt.
                    last[1] = Math.max(last[1],interval[1]);
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}