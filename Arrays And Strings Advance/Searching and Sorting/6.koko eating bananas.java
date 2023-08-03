// Link -> // https://leetcode.com/problems/koko-eating-bananas/

// return min integer such that koka eat all banana within n hours

/* Approach:
1.get has as max allowed speed
2.las as 1 min speed
3.calculate mid 
4.totaltime to get hrs req at mid speed
5.loop on array and calculate time as piles[i] + mid - 1/mid
6.if totaltime exceeds h then we want larger speed so we update or lowest allowed speed else we update has


piles = [3,6,7,11], h = 8
if speed = 11 -> 1+1+1+1 = 4hrs
if speed = 1 ->  3+6+7+11 = 27hrs
*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int las = 1; //lowest allowed speed
        int has = 0; //highest allowed speed -> max in piles
        
        for(int pile : piles) {
            has = Math.max(pile,has);
        }
        
        while(las < has) {
            //mid as allowed speed
            int as = (las + has)/2;
            //time req for this speed
            int totalTime = 0;
            for(int pile : piles) {
                int time = (pile + as - 1)/as; //take ceil
                totalTime += time; 
            }
            if(totalTime > h) {
                //if time exceed the limit of allowed hrs
                las = as + 1;
            } else {
                has  = as;
            }
        }
        return las;
     }
}