// link-> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// duplictes are allowed

/*
1.same as for 1st case but one more addition to previous.
2.if numns[hi] == mid h toh we cant decide where our ans is so we can decrement hi by 1 -> lo and hi come closer 
nums -> 2 2 5 7 7 7
        7 7 2 2 5 7
*/

class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo < hi) {
            int mid = (lo + hi)/2;
            if(nums[hi] > nums[mid]) {
                hi = mid;
            } else if(nums[hi] < nums[mid]) {
                lo = mid + 1;
            } else {
                //equal ka case
                hi--;
            }
        }
        return nums[lo];
    }
}