// Link -> https://leetcode.com/problems/maximum-subarray/
//  Given an integer array nums, find the subarray with the largest sum, and return its sum.
//based on Kadane's algorithm - O(n)

/*Approach
arr -> a b c d e f g
All subarrays of above array are:
       a             
       ab          b    
       abc         bc       c
       abcd       bcd      cd       d
       abcde      bcde     cde      de      e
       abcdef     bcdef    cdef     def     ef    f
       abcdefg    bcdefg   cdefg    defg    efg   fg    g
to check all sum by two loops - O(n2)

if a>0 then we dont have to check subarray starting from b as a is added them and a > 0 so subarr starting from a
will have greater value
if ab > 0 so dont have to check subarr of c
if abc < 0 then dont have to check for abc ke aagey ke sarre subarr
if d> 0dont check e subarr
if de< 0 -> check only f

arr-> 2  4  -7  3  6 -12   5 3
    -->2                  -->5
    ----->6               ----->8 
    -------->-1                        --> max(all sums) -> 9
               -->3
               ------>9
               ---------->-3
1.jab tak sum positive aa rha h add krte rho sum ke negative hote hi ruk jayo 
2.and next se nya sum lo and return max of all the sum
*/

// code
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            if(sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}