// Link -> https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// given m * n sorted matrix return the kth smallest matrix

/* Approach :
1.lo at min and hi at max value in array
2.calculate mid 
3.check how many elements are smaller than mid -> O(n)
4.j ko row ke last col pe and if value greater h mid se j pointer piche layo and if value is smaller then add 
 count to j + 1
              lo,i
                      <-j
              1   5   9
 mat[i][j] =  10  11 13
              12  13  15
                      hi,

*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int lo = matrix[0][0];
        int hi = matrix[m - 1][n - 1];
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            int count = 0;
            int j = n - 1;
            for(int i = 0; i < m; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    //while values are greater dec j counter
                    j--;
                }
                
                count += (j + 1);
            }
            
            if(count < k){
                //hme mid se less no's mile then our requirement -> we have to increase mid so lo = mid + 1
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}