// link -> https://leetcode.com/problems/trapping-rain-water/
// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it can trap after raining.

/* Approach :
1.Get max from left side 
2.Get max from right side
3.The amount of water stored will be previous value plus min of left and right[i] usme se minus apni height[i]
          i i i i i i
height -> 0 1 0 2 1 0 1 3 2 1 2 1
left ->   0 1 1 2 2 2 2 3 3 3 3 3
          3 3 3 3 3 3 3 3 2 2 2 1 <- right
val =     0+0+1+0+1+2+1+0+0+1+0+0 = 6 unit water

*/

class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        for(int i = 0;i < left.length;i++){
            if(i == 0) {
                left[i] = height[i];
            } else {
                left[i] = Math.max(height[i],left[i - 1]);
            }
        }
        int[] right = new int[height.length];
        for(int i = right.length - 1;i >= 0;i--) {
            if(i == right.length - 1) {
                right[i] = height[i];
            } else {
                right[i] = Math.max(height[i],right[i + 1]);
            }
        }
        int val = 0;
        for(int i = 0;i < height.length;i++) {
            val += Math.min(left[i],right[i]) - height[i];
        }
        return val;
    }
}