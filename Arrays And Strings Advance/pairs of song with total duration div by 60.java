// link -> https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// You are given a list of songs where the ith song has a duration of time[i] seconds.\
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
// Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

/*Approach ->
for simplicity let us not take 60 but take 5
1.create hashmap map which will contain how many numbers have remenender as 0,1,2,3,4 we will only store count
2.now 1 and 4 remainders will pair up and they will divisible by 5 so number of pairs possible will be 2*2 = 4

m-2
1.create frequecny map and variable result if res += fmap(5-rem) i.e add count of 5-rem
when we parse on 2 it gives remender 2 so we check for 3 if it present then add it count
for zero first check if any thing is present in 0 or not if present then add its count
now 8 comes gives remainder 3 it will look for 2 where 2 no is present it will pair up with both so res += 2
 2 7 16 5 8 19 4 11 20 15
0->5,20,15 ->3
1->16,11-> 2
2->2,7->2
3->8->1
4->19,4->2
res = 0+0+0+0+2+1+1+2+1+2
*/

// code
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] fmap = new int[60];
        int res = 0;
        for(int t : time) {
            int val = t % 60;
            if(val == 0) {
                res += fmap[0];
            } else {
                res += fmap[60-val];
            }
            fmap[val]++;
        }
        return res;
    }
}