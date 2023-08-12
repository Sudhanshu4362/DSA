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

// O(NlogN) -> solution
/* Approach:
1.we will create trails list 
2.loop on array and decide wheather it can be part of last list or not if yes clone it and add next element to it
3.for same length sequences discard the list with greater value
4.we will maintain end points of lists and store it in tails array

TO SEARCH RIGHT SPOT FOR NOT GREATER CASE : 
use Arrays.binarysearch(tails,0,len-1,nums[i]) but it is not in array so idx will be -ve.and it also gives its 
potential position also but in -ve i.e if hota toh is index pe hota 

       i i i i  i i  i  i i i i i  i
arr -> 0 8 4 12 2 10 6 14 1 9 5 13 3
    0
    0-8 -> X
    0-4 -> X
    0-4-12 -> X
    0-2 -> X
    0-2-10 -> X
    0-2-6-14 -> X
    0-1
    0-2-6-9
    0-1-5 -> X
    0-2-6-9-13
    0-1-3

 tails array will contain end point of each list and we update if we get better list for same lengths by replacing
 that number in array.
 tails : [0,1,3,9,13] -> final array after parsing all, length of this array is lis
first parse 0 and for 8 check if 8 can be added next to zero greater h add it
4 8 ke peeche nhi lg skta but zero ke peeche lg skta h and discard 0-8 (4 < 8) bcz if 4-8 ke bech ko koi number 4
ke peeche hi lg skta h.
2 aayega to 0-4 bhi discard
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 1;
        
        int[] tails = new int[nums.length];//contains end points of arr
        tails[0] = nums[0];//add 1st element to list i.e end point to tails
        
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > tails[len - 1]){
                //if greater -> increase the lenngth and add it to new list
                len++;
                tails[len - 1] = nums[i];//add end point to array 
            } else {
                //not greater then last search for right spot to add next element
                int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]);
                
                if(idx < 0){
                    //make idx +ve
                    idx = -idx;
                    idx = idx - 1;//make position to index
                }
                tails[idx] = nums[i];
            }
        }
        
        return len;
    }
}