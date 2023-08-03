// Link ->  https://leetcode.com/problems/split-array-largest-sum/
// split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

/* Approach:
1.get hisum as max range i.e sum of all elements
2.losum as max value in array -> min partion
3.calculate mid 
4.count of partion and curr sum to check how many partion needed according to this limit
5.loop on array and calculate currsum if it exceeds limit inc the count of partion
6.if count of partion k se jyada h means sum h limits tight h so we have to go to right side to inc mid else
go to left side

num -> 7 2 5 10 8    ,k - 2
 lo hi
[10,32] m- 21  2=2     [10,21] m-15   3>2   [16,21] m-18    2=2   [16,18] m-17    3>2    [18,18]
-------------  -->    --------------  -->    ------------    -->  ------------     -->   lo = ho -> ans =18
[10,21][22-32]         [10,15][16,21]        [16,18][19,21]       [16,17][18-18]

1. for 21 we need 2 partition as 7,2,5 and 10 8 which is valid but we look for more shorter range so we update our
lo = 10 and hi to 21 and again calculate mid for this
2. for 15 mid we need 3 partion i.e 7,2,5 and 10 and 8 -> sum is smaller which is invalid so we want larger sum so 
update lo and hi to 16,21

7->2,5,10,8 ->[7,25] -25
7,2->5,10,8 ->[9,23] -23
7,2,5->10,8 ->[14,18] -18 -> best partition
7,2,5,10->8 ->[24,8] - 24
//sabse kharab partion minimum sum de
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        int hisum = 0;//max sum
        int losum =Integer.MIN_VALUE; //if each element is individually partioned get max value
        
        for(int num: nums) {
            hisum += num;
            losum = Math.max(losum,num);
        }
        
        while(losum < hisum) {
            //calculating mid as limit
            int limit = (losum + hisum)/2;
            //partition needed according to this limit or mid
            int countParts = 1;
            // currSum is partion kadane
            int currSum = 0;
            for(int num : nums) {
                //agar sum kam h limit se
                if(currSum + num <= limit){
                    currSum += num;
                } else {
                    //sum jyda h limit se new partion needed
                    currSum = num;
                    countParts++;
                }
            }
            if(countParts > k) {
                //allowed se jyada partion pe
                losum = limit + 1;
            } else {
                //kam h
                hisum = limit;
            }
        }
        return losum;
    }
}