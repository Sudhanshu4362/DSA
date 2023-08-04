// Link ->https://leetcode.com/problems/find-k-th-smallest-pair-distance/

//return the kth smallest distance among all the pairs nums[i] and nums[j]

//visulaize as 2D and use binary search
/* Approach :
1.Sort the array
2.lo at smallest gap -> b/w immediates elements in array
3. hi at max gap -> last -first element 
4. Calculate mid
5.check how many gaps are less then mid  if yes move j++
6.if you encountered greater number then mid means after that all are greater gap so count me j - i - 1 add kr do
7.if count is less then k we are getting less number so inc the mid toh right side me jao else left me
    2  3  6  9  15   k = 5
2-  x  1  4  7  13
3   x  x  3  6  12
6   x  x  x  3  9
9   x  x  x  x  6
15  x  x  x  x  x
x -> are repeated gaps not required
*/

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        for(int i = 0;i < nums.length - 1;i++) {
            //immediates me lowest gap
            lo = Math.min(lo,nums[i + 1] - nums[i]);
        }
        int hi = nums[nums.length - 1] - nums[lo];
        while(lo < hi) {
            int mid = (lo + hi)/2;
            int count = 0;
            int j = 0;
            for(int i = 0;i < nums.length;i++){
              while(j < nums.length && nums[j] - nums[i] <= mid) {
                  j++;
               }
            count += (j - i - 1);
            }
            if(count < k) {
              lo = mid + 1;
            } else {
               hi = mid;
            }
        }
        return lo;
    }
}