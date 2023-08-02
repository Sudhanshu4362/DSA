// link -> https://leetcode.com/problems/sum-of-subsequence-widths/
//The width of a sequence is the difference between the maximum and minimum elements in the sequence.
// intituion -> add lrgest of all sequences - smallest of all sequences 
/* Approach:
1.sort the Array
2.loop on array and add the ith value and minus the ith value from last
     i i i i
arr- a b c d
     i i i i
     1->1.a-1.d
     2->2.b-2.c
     4->4.c-4.b
     8->8.d-8.a
arr -> a b c  

all sequences are -> - - -
                     - - c -> c-c
                     - b - -> b-b
                     a - -    a-a
                     - b c    c-b
                     a - c    c-a
                     a b -    b-a 
                     a b c    c-a
                     ---------------
                     [4a-2b-c+4c+2b+a]
 i i i
[1,2,3]
ans = 0,p = 1->2->4
ans = 0+1*1-1*3 =-2
ans = -2+2*2-2*2 =-2
ans = -2+4*3-4*1 = 6
*/


// code:
class Solution {
    long MOD = 1000000007L;
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long ans = 0;
        long p = 1;
        for(int i = 0;i < nums.length;i++) {
            // int fromst = p * nums[i]
            // int fromlst = p * nums[nums.length -1 -i];
            // ans = (ans + fromst - fromlst) % MOD
            ans = (ans + p * nums[i] - p * nums[nums.length - 1 - i]) % MOD;
            p = (p * 2) % MOD;
        }
        return (int)ans;
    }
}