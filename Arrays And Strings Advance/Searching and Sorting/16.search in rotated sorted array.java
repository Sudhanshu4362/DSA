// link -> https://leetcode.com/problems/search-in-rotated-sorted-array/

/* Approach :
1.Binary search the array
2.find pivot i.e 2, pivot se last tak sorted h and usse pehle wale bhi sorted h
3.get no of rotations by searching lowest element
4.one way to search is use binary search in both sides i.e from start to pivot index i.e rot and from rot to end
5.

             2   15 18 32 37 50 55 60
3 rotation ->55  50 60 2  15 18 32 37
*/

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            //search lowest element
            int mid = (lo + hi)/2;
            if(nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        // get no of rotations by finding lowest element index
        int rot = lo;
        lo = 0;
        hi = nums.length - 1;
        while(lo <= hi) {
            //searching our target
            int mid = (lo + hi)/2;
            int idx = (mid + rot)%nums.length;
            if(nums[idx] == target) {
                return idx;
            } else if(nums[idx] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            //search lowest element
            int mid = (lo + hi)/2;
            if(nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        // get no of rotations by finding lowest element index
        int rot = lo;
        int ls = binarySearch(nums,0,rot - 1,target);
        if(ls != -1){
            return ls;
        }
        int rs = binarySearch(nums,rot,nums.length - 1,target);
        return rs;
    }
    public int binarySearch(int[] arr,int lo,int hi,int val){
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(val > arr[mid]){
                lo = mid +1;
            } else if(val < arr[mid]){
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}