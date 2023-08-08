// Link -> https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//duplicates me value search

//based on min1 and min2 problem first do that
/* Approach:
1.lo at 0 and hi at len-1
2.calculate mid 
3.3 cases nums[mid] < nums[hi],nums[mid] > nums[hi],nums[mid] == nums[hi]
4.1st ke liye mid to hi is sorted -> find target here if target is greater than mid and lower then hi move lo to
mid+1 to search there else target in unsorted part so move hi to hi-1
5.2nd case-> mid is greater then hi -> i.e lo to mid is sorted,if target is greater then lo but less then mid
target is in sorted part so move hi to mid-1 else search in unsorted part -> lo to mid +1
6.3rd case equal h so just move hi--
*/

class Solution {
    public boolean search(int[] nums, int target)  {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] < nums[hi]){ // mid to hi is sorted
                if(target >= nums[mid] && target <= nums[hi]){
                    //if target is in sorted part
                    lo = mid + 1;
                } else {
                    //target in unsorted part
                    hi = mid - 1;
                }
            } else if(nums[mid] > nums[hi]) { // lo to mid is sorted
                if(target >= nums[lo] && target <= nums[mid]){
                    //sorted
                    hi = mid - 1;
                } else {
                    //unsorted
                    lo = mid + 1;
                }
            } else {
                //equal
                hi--;
            }
        }
        
        return false;
    }
}