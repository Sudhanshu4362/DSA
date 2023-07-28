// link : https://leetcode.com/problems/squares-of-a-sorted-array/

/* approach 
l and r at extreams of array and check for  absolute of nums[l] and nums[r] and create a res array of same length 
and a pointer k at end and compare l,r and put square of greater number at k and move k-- and move the index of 
greater number
[-4,-1,0,3,10]
l = -4 ,r = 10
10 is greater put 10^2 at k and r-- and k--
*/

//code
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int k = res.length - 1;
        while(k >= 0) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[k] = nums[l] * nums[l];
                l++;
            } else {
                res[k] = nums[r] * nums[r];
                r--;
            }
            k--;
        }
        return res;
    }
}