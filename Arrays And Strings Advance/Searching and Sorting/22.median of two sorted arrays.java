// link -> https://leetcode.com/problems/median-of-two-sorted-arrays/

//Given two sorted arrays nums1 and nums2 of size m and n respectively,return the median of the two sorted arrays
//The overall run time complexity should be O(log (m+n)) i.e without merging them

/* Approach :
1.get median 1 and median 2 -> (m + n + 1)/2,(m + n + 2)/2 -> handles both odd and even 
2.we have to find these elements from merged arrray
3.getKthelemenntfrommergedarray -> get kth element from combined array
4.find k/2th of both A,B arrays ,if A[k/2] < B[k/2] then then ans will not in first half of a and k/2 elements in 
A and k/2 elements will be smaller.total k-2 elements will be swaller so at max it can be max to k - 1 elements
5.discard that k/2 elements in A and now search in right half of that array and whole B
6.after discarding now we have to search k/2th element as we have discarded one half tottal me se k -> half me k/2th


A -> 5   9 15 18 20 25 35
B->  10 12 17 22 24

even - 2 median ,odd -> 1 median
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int m1 = (m + n + 1)/2;//median1
        int m2 = (m + n + 2)/2;//median2

        //get both medians
        int median1 = getKthElementFromMergedArr(nums1,nums2,m1,0,0);//search m1
        int median2 = getKthElementFromMergedArr(nums1,nums2,m2,0,0);//search m2
        
        return (median1 + median2)/2.0;
    }
                                          //A            B         m     strt1  strt2 pt of both arr
    public int getKthElementFromMergedArr(int[] nums1,int[] nums2,int k,int s1,int s2) {
        if(s1 >= nums1.length) {
            // s1 is ended search in second arr
            return nums2[s2 + k - 1];
        }
        if(s2 >= nums2.length){
            // s2 is ended search in first arr
            return nums1[s1 + k -1];
        }
        if(k == 1) {
            //both array have 1-1 element
            return Math.min(nums1[s1],nums2[s2]);
        }
        int el1 = Integer.MAX_VALUE;
        if(s1 + k/2 - 1 < nums1.length) {
            //start se k/2th element
            el1 = nums1[s1 + k/2 -1];
        }
        int el2 = Integer.MAX_VALUE;
        if(s2 + k/2 - 1 < nums2.length) {
            el2 = nums2[s2 + k/2 -1];
        }
        if(el1 < el2) {
            return getKthElementFromMergedArr(nums1,nums2,k - k/2,s1 + k/2,s2);//discard A ka left
        } else {
            return getKthElementFromMergedArr(nums1,nums2,k - k/2,s1,s2 + k/2);//discard B ka left
        }
    }
}