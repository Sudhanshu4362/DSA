// Link -> https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

/*
Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
*/

/* Approach:
siimilar to previous one
1.lo at 1 and hi at m*n
2.calculate mid
3.if i*j is greater then mid move j till smaller found
4.add j to count if smaller no found

  1  2  3
  2  4  6
  3  6  9

*/

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m * n;
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            int count = 0;
            int j = n;
            
            for(int i = 1;i <= m;i++){
                while(j >= 1 && i * j > mid){
                    j--;
                }
                count += j;
            }
            if(count < k){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}