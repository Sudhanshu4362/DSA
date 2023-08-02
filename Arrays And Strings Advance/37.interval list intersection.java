// link -> https://leetcode.com/problems/interval-list-intersections/
// return the intersection of two disjoint sorted lists

//intituion -> for intersection the intersection interval lie from max of starting point to min of ending point
// for [0,2],[1,5] -> intersection is [1,2]
/* Approach:
1.i at fl and j at sl and Maintain a res list.
2.For intersection get max of starting point and min of ending point as lo and hi.
3.if lo is less then equal to hi add this interval to the list
4.Increase the pointer for that whose end point is less
       i      i      i      i
1 -> {[0,2],[5,10],[13,23],[24,25]}
       j      j      j       j
2 -> {[1,5],[8,12],[15,24],[25,26]}
res->{[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]}
*/

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0],secondList[j][0]);
            int hi = Math.min(firstList[i][1],secondList[j][1]);
            
            if(lo <= hi) {
                list.add(new int[]{lo,hi});
            }
            if(firstList[i][1] < secondList[j][1]) {
                //jiska ending point kam hoga usko move krege
                i++;
            
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}