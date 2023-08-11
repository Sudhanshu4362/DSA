// BASED ON LIS
// Link -> https://leetcode.com/problems/russian-doll-envelopes/

/*you are given 2D array of integer of envelops where envelop[i] = [wi,hi] represents width and height of an envelop
one envelop fit into another if and only if both width and height of one envelop are greater then the other envelope's
width and height.
return max no. of env. you can russian doll i.e put one inside the other
*/

/* Approach:
  1. sort envelop on height and take lis on weight and if height is same then envelop with greater width comes 1st
  2.here for equal cases we cant fit them in envelop so try new one
  3.

   a  b  c  d  e  f  g  h
   8  1  4  3  5  2  6  7 -> envelop height
   1  2  3  4  5  6  7  8 -> envelop width

sort heights -> b  f    d    c    e    g    h       a -> we checked height and to check width we take lis to 
                                                        confirm if we can accumulate prev.env.to next or not
*/

//TLE for this solution -> better solution O(NlogN)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //sort -> 2d arr  brdg1 brdg 2
	 Arrays.sort(envelopes,(e1,e2) -> {
            if(e1[0] != e2[0]) {
                return e1[0] - e2[0];
            } else {
                return e2[1] - e1[1];
            }
        });
	    
	    int[] lis = new int[envelopes.length];
	    lis[0] = 1;
	    
	    for(int i = 1; i < lis.length; i++){
	        int max = 0;
	        for(int j = 0; j < i; j++){
                //check south banks for all j to i's
	            if(envelopes[j][1] < envelopes[i][1]){
	                max = Math.max(max, lis[j]);
	            }
	        }
	        
	        lis[i] = max + 1;
	    }
	    
	    int len = 0;
	    for(int val: lis){
	        len = Math.max(len, val);
	    }
	    
	    return len;
    }
}
