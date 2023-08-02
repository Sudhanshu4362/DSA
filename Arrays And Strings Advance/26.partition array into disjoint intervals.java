// link -> https://leetcode.com/problems/partition-array-into-disjoint-intervals/
//partition array into left and right such that:
//Every element in left is less than or equal to every element in right
//left and right are non-empty
//left has the smallest possible size return size of left
/* Approach ->
1.Maintain a max from left array and min from right array.
2.again loop on nums array check for left is less than or equal to right[i+1]
3.if yes return ans = i + 1

arr -> 5 6 7 3 4 |8 9 14 12 11 10
maxfl->5 6 7 7 7 |8 9 14 14 14 14
minfr->3 3 3 3 4 |8 9 10 10 10 10
before 8 max from left is less than min from right(i + 1 = 4+1 =5 size of left array)
*/

//code:
class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        .//max from left array
      for(int i = 0; i < nums.length; i++){
            if(i == 0){
                left[i] = nums[i];
            } else {
                left[i] = Math.max(nums[i], left[i - 1]);
            }
        }
        //min from right array
         for(int i = nums.length - 1; i >= 0; i--){
            if(i == nums.length - 1){
                right[i] = nums[i];
            } else {
                right[i] = Math.min(nums[i], right[i + 1]);
            }
        }
        int ans = -1;
        for(int i = 0; i < nums.length - 1; i++){
            if(left[i] <= right[i + 1]){
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}

//
/* Approach-2 ->
O(1) space me time O(n) me
1.we will try to draw line after every element and update it later on
2.mtp and mts  at zero and if we get smaller number than mtp we will update partion and update mtp to mts
mts->i tak ka max
mts ms ms        ms ms ms
 5  |6  7  3| 4| 8  9  14 12 11 10 
mtp     mp  
max till partition
*/


class Solution {
    public int partitionDisjoint(int[] nums) {
        int pi = 0;
        int mtp = nums[0];
        int mts = nums[0];
        
        for(int i = 1;i < nums.length;i++){
            mts = Math.max(nums[i],mts);
            if(nums[i] < mtp) {
                // we may have a partion here
                pi = i;
                mtp = mts;
            }
        }
        return pi + 1;
    }
}