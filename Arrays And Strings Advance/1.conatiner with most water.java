// problem link : https://leetcode.com/problems/container-with-most-water/

// given integer array of height of length n return a max amount of water a container can store
/* approach : [5,6,3,7,2] 
left at starting index that is 5 and right at end index that is 2 now calculate the area of this conatiner by using
min of height of l,r and r-l
if h[l] < h[r] l++ else r--
areas for above example 2 * 4 = 8 
                        5 * 3 = 15 -> is maxiumum return it 
                        6 * 2 = 12
                        3 * 1 = 3
*/

/* why this approach -> after checking (5,2) we dont have to check for 6,2,3,2,7,2 as height remains same but width 
decreses resulting in lesser area */
//code

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while(l < r) {
            int area = Math.min(height[l],height[r]) * (r - l);
            res = Math.max(res,area);

            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}