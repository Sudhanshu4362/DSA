// link - > https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
// return the number of contiguous non-empty subarrays such that the value of the maximum array element in that 
// subarray is in the range [left, right].

/* approach:
two pointers s and e at -1 which indicates start and end of subarray if number is valid move end [>= left && <= right]
if inavlid number encountered then start new sequence from here s = e = i and if value is lesser then left do nothing 
do not move end and add values to previous sequence and for every iteration add (e - s) to result.
s       s
  3 5 4 7  2 3 4 1 4 2  && [2-5]
  0 1 2 3  4 5 6 7 8 9
e e e e e  e e e   e e
0+1+2+3+1+2+3+3+5+6 = 26
*/

//code:
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = -1;
        int end = -1;
        int res = 0;
        
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] >= left && nums[i] <= right) {
                //for in range move only end
                end = i;
            } else if(nums[i] > right) {
                //for greater than right 
                end = start = i;
            } else {
                //for lesser do nothing only add to res
            } 
            res += (end - start);
        }
        return res;
    }
}