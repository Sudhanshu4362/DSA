// Link -> https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
// return the min capacity of ship so that all packages shipped within N days n- partitions
// we check for a capacity how many days needed to ship in N days

//similar to split array-largest sum
/* Approach:
1.get hicap as max range i.e sum of all elements
2.locap as max value in array -> min partion
3.calculate mid as capacity 
4.count of days and curr weight to check how many days needed according to this capacity
5.loop on array and calculate currwt if it exceeds capacity inc the count of days
6.if count of days N se jyada h means wt h cap tight h so we have to go to right side to inc mid else
go to left side

weights -> 1 2 3 4 5 6 7 8 9 10  day = 5

lo hi
[10,55] m- 32  2<5     [10,32] m-21   3<5   [10,21] m-15    5=5   [10,15] m-12  6>5    [13-15] m-14  6>5  [15-15]ans
-------------  -->    --------------  -->    ------------    -->  ------------   -->  -------------- --->  lo = hi 
[10,32][33-55]         [10,21][22,32]        [10,15][16,21]       [10,12][13-15]      [13,14][15,15] 

32 ke liye 2 hi din me sara package bhej skte h 
*/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int locap = Integer.MIN_VALUE; //kam se kam itni capacity honi chahiye ki heavier aa jaye
        int hicap = 0;
        for(int wt : weights) {
            hicap += wt;
            locap = Math.max(lac,wt);
        }
        
        while(locap < hicap) {
            int cap = (locap + hicap )/2;
            int daysReq = 1;
            int currPartwt = 0;
            
            
            for(int wt : weights) {
                if(currPartwt + wt <= cap) {
                    currPartwt += wt;
                } else {
                    currPartwt = wt;
                    daysReq++;
                }
            }
            if(daysReq > days) {
                locap = cap + 1;
            } else {
                hicap = cap;
            }
        }
        return locap;
    }
}