// link -> https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

/*
Approach:
1.sort the array
2.if starting point is less then end point then they can be burst by same arrow and modify end point to min of 
previous end and point[1]
3.if start point is greater then end point then inc. the arrow counter 
arr->   {[10,16],[2,8],[1,6],[7,12]}
sorted->{[1,6],[2,8],[7,12],[10,16]}
          i
                 10------16
            7------12 
                  ^         
      2-------8
    1----6
       ^
1,6 and 2,8 will need 1 arrow if next ballone is also staring before 6 then they can be burst else we need new arrow
7 is greater then 6 so new arrow is needed
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> {
            if(a[0] > b[0]) {
                return 1;
            } else if(a[0] == b[0]) {
                return 0;
            } else {
                return -1;
            }
        });
        int count = 0;
        int end = Integer.MAX_VALUE;
        for(int[] p : points) {
            if(p[0] > end) {
                //new arrow needed
                count++;
                end = p[1];
            } else {
                //same arrow
                end = Math.min(end,p[1]);
            }
        }
        return count + 1;
    }
}