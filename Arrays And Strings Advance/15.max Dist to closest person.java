// link -> https://leetcode.com/problems/maximize-distance-to-closest-person/
// 0 -> empty seats
// 1-> filled seates
//seat at that posi wheare dist to closest person is maximized


/*
Approach:
1.loop on seats[i] if zero do nothing if 1 then if j < 0 then ans = i else (i -j)/2 bcz we have to place b.w the 1s
 and move j to that i
 return max of all the gaps
 for last ans = n -1-j

  i i i i i i i i i i i i i i i i
  0 1 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0
j   j         j
gap = 1->5/2 = 2-> 10/2=5
*/
// code
class Solution {
    public int maxDistToClosest(int[] seats) {
        int j = -1;
        
        int res = 0;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                int ans = 0;
                
                if(j < 0){
                    ans = i;
                } else {
                    ans = (i - j) / 2;
                }
                
                res = Math.max(res, ans);
                j = i;
            }
        }
        
        int ans = seats.length - 1 - j;
        res = Math.max(res, ans);
        
        return res;
    }
}