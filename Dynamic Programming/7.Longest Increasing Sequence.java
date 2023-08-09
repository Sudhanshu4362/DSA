// Link -> https://leetcode.com/problems/longest-increasing-subsequence/

// find the length of longest subsequence of a given sequence such that all elements of the subsequence are sorted
// in increasing order

/* Approach:1-> O(N^2) -T
1.At any number x we will store longest increasing seq.at that number
for e.g at 7 we will store lis ending at 7
2.lis[0] = 1
3.loop on array and a max to calculate max LIS for all elements in array
4.nested loop j from 0 to that number i.e and get max lis for all and add 1 to max 
5.again loop on Lis array and get max length

   ------>dp 
   arr-> 10   9   2   5   3   7   101    18
   lis-> 1    1   1   2   2   3    4      4
inc.seq->10   9   2   25  23  27    
                              257
                              237                                                                          
                      
At 10 longest inc seq is 10
at 5 we can add 2 bwfore 5 to get LIS
At 7 -> 2 ke piche lgke 27 ,5 ke piche lgke 257 and 3 ke piche lgke 237 bnayega 7-> max length=3
At 101-> 10 se 10,101 and 9 se 9 101,2 se 2 101,5 se 2 5 101,3 se 2 3 101,7 se 2 5 7 101 max is 4 length
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        lis[0] = 1;//first element kud pe khthm hoga and uska length
        for(int i = 1;i < nums.length;i++){
            int max = 0;
            for(int j = 0;j < i;j++){
                //j traverse 0 to i to get max lis in that range
                if(nums[j] < nums[i]){
                    max = Math.max(max,lis[j]);
                }
            }
            // max me khud ko add
            lis[i] = max + 1;
        }
        int len  = 0;
        for(int val : lis){
            len = Math.max(val,len);
        }
        return len;
    }
}