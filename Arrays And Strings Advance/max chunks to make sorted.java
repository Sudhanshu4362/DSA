// link -> https://leetcode.com/problems/max-chunks-to-make-sorted/
// kitne parts me divide kr skte h such that un parts ko sort krne pe pura array sort ho jaye, duplicates not allowed
// T - o(n) and  S - o(1)

/* approach->
take max so far of array at each index if max == inedx than to that index there is no number greater then that max
so we can draw a partition at that index

nums -> 1 2 0| 4 3| 5
index ->0 1 2| 3 4| 5
max ->  1 2 2| 4 4| 5
        0 1 2  3 4  5 -> each individually sorted
*/

// why -> if idx == mx so that max number will come at that index and we can divide on that

// code
class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int count= 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
            if(max == i){
                count++;
            }
        }
        return count;
    }
}
