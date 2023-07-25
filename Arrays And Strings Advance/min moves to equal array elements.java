// link -> https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
// Given integer array nums of size n,return the minimum number of moves required to make allarrayelements equal.
// In one move, you can increment or decrement an element of the array by 1.

/* Approach:
1. sort the array
2.l == 0 and r = end and res = 0
3.res = nums[ri] - nums[li]
3.why median-> bcz as it will require lesser number of steps for larger numbers

8 2 9 3 7 5 6
2 3 5 6 7 8 9 -> after sorting median is 6
6-2 =4,6-3=3,6-5=1,6-6=0,7-6=1,8-6=2,9-6=3 -> total number of operations =14 a sixes will cuts each other eff.9-2+8-3+7-5
l l l
2 3 5 6 7 8 9
        r r r
res = (9-2) + (8-3) +(7 - 5)
*/
    
// code:
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int li = 0;
        int ri = nums.length - 1;
        int res = 0;
        while(li < ri) {
            res += nums[ri] - nums[li];
            li++;
            ri--;
        }
        return res;
    }
}