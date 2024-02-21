// arr = 20 4 14 26 7

/* Approach:
Exp => Max(a,0) => compare from 0 - length-1 and gives max.
faith => max(a,1) => compare from 1 - length-1 and gives max.
EWF => compare arr[0] and max(a,1).
*/

class Solution {
    function moa(int[] arr,int idx){
        if(i == arr.length - 1) {
            return;
        }
        int misa = moa(arr,idx + 1);
        int max = Math.max(arr[idx],misa);
        return max;
    }
}