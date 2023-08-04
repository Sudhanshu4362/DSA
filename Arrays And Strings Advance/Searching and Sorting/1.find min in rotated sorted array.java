// Link -> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
/* approach :
1.lo and hi at 0 and length
2.calculate mid = (lo + hi)/2
3.if mid < hi ->smaller element in left half
4.if mid > hi ->smaller element in right half
                       m     h
un rotated arr = 10 20 30 40 50 -> a[hi] > a[mid] -> smallest element left side me h
                       m     h
1 bar rtd -      50 10 20 30 40 -> a[hi] > a[mid] -> smallest element left side me h
                       m      h
2         -      40 50 10 20 30 -> a[hi] > a[mid] -> smallest element left side me h
                        m     h
3         -      30 40 50 10 20 -> a[hi] < a[mid] -> smallest element right side me h
                        m     h
4         -       20 30 40 50 10 -> a[hi] < a[mid] -> smallest element right side me h
*/

class Solution {
    public int findMin(int[] nums) {
      int lo = 0;
      int hi = nums.length -1;
      while(lo < hi){
          int mid = (lo + hi)/2;
          if(nums[hi] > nums[mid]){
              //left half = lo to mid ,growth in right side check for left
              hi = mid;
          } else {
              //right half = mid+1 to hi,growth in left side check for right
              lo = mid + 1;
          }
        }
        return nums[lo];  
    }
}