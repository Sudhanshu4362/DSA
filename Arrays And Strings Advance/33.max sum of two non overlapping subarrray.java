// link -> https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

/* Approach :
1.Loop on Array and store a left array containing max of sum of a window 
2.same for right side se and store max sum of second window
3.Now process each window i.e 2156(sum = 14) ki window usse agey ki best window dekhega jo 950(14) h 
5609 and  038 will give better sum i.e 31
4,3
arr -> a b   c    d    e        f     g    h    i    j
sum -> a ab abc abcd  bcde     cdef
max ->          abcd  max(abcd, ....
                         cdef)
                i  i  i   i
arr -> 2  1  5  6  0  9   5  0   3   8
sum -> 2  3  8  14 12 20  20 14  17  16
left->          14 14 20  20 20  20  20
       8  12 11 15 14 14  8  11  11  8  
       15 15 15 15 14 14  11            <- right
*/

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int fl, int sl) {
        int max1 = getMax(nums,fl,sl); //fl pehle h and sl bad me i.e 4 wala pehle and 3 wala bad me
        int max2 = getMax(nums,sl,fl);//sl pehle ho and fl bad me i.e 3 wala pehle and 4 wala bad me
        
        return Math.max(max1,max2); //return max
    }
    public int getMax(int[] nums,int fl,int sl) {
        int[] left = new int[nums.length];
        int sum = 0;
        
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
            if(i == fl - 1) {
                //first set i.e 2156
                left[i] = sum;
            } else if(i >= fl) {
                // 1 add krege and i-fl piche jake subtract bhi krege
                sum -= nums[i - fl];
                left[i] = Math.max(left[i - 1],sum);
            }
        }
        //same for right side
        int[] right = new int[nums.length];
        sum = 0;
        for(int i = nums.length - 1;i >= 0;i--) {
            sum += nums[i];
            if(i == nums.length - sl) {
                // 1st set 038
                right[i] = sum;
            } else if(i < nums.length - sl) {
                sum -= nums[i + sl];
                right[i] = Math.max(sum,right[i + 1]);
            }
        }
        int max = Integer.MIN_VALUE;
        //fl-1 pe left set pura hua tha and len-sl se right set so loop and check for maximum
        for(int i = fl - 1;i < nums.length - sl;i++) {
            max = Math.max(left[i] + right[i + 1],max);
        }
         return max;
    }
}