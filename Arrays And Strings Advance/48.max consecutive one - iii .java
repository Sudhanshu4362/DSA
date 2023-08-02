// Link -> https://leetcode.com/problems/max-consecutive-ones-iii/
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array 
//  you can flip at most k 0's.

/*Approach:
1.we can flip k zeros i.e we can max acquire 3 zeros in a sequence
2.release if count of zeros exceeds k so release zeros till become valid

       i i i i i i i i i i i i i
arr -> 0 0 1 1 0 0 1 1 1 0 1 1 0 0 0 1 1 1 1   k = 3
       j j j j j
       1st seq = 01100 -5
       2nd -> 11001110 -8
       3rd - 01110110 -8
*/

// code:
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;

        int res = 0;
        int countz = 0;

        while(i < nums.length){
            if(nums[i] == 0){
                //count number of zeros
                countz++;
            }
            
            while(countz > k){
                //count of zeros exceeds k release to become valid
                if(nums[j] == 0){
                    //dec count of zero while releasing 
                    countz--;
                }
                j++;
            }
            // return max of lengths
            res = Math.max(res, i - j + 1);
            i++;
        }
        
        return res;
    }
}