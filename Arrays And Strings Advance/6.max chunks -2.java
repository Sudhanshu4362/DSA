// link -> https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
// now duplicates are allowed
// T - O(n) and S - O(n)

/* Approach ->
[a] * [b,c,d,e,f] -> * pe divide kr skte h if [a] ka max is less than min of [b,c,d,e,f] because they cant be merged
take min from right and max from left and draw a partition if max from left is less than the min from right + 1(or equal)

 orig -> 4 5 2 3| 9 8 6 7| 10
 minfr ->2 2 2 3| 6 6 6 7| 10 <-
 maxfl ->4 5 5 5| 9 9 9 9| 10
               5 < 6     9<10
               maxfl < minfr
*/

// code
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] minfr = new int[arr.length];
        minfr[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2;i >= 0;i--) {
            minfr[i] = Math.min(arr[i],minfr[i + 1]);
        }
        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length - 1;i++) {
            max = Math.max(max,arr[i]);
            if(max <= minfr[i + 1]){
                res++;
            }
        }
        return res + 1;
    }
}