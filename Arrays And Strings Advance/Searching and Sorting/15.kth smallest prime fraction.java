//  Link -> https://leetcode.com/problems/k-th-smallest-prime-fraction/
// sorted integer array containing 1 and prime numbers return the kth smallest fraction,return as an array of integer
// of size 2 where ans[0] == arr[i] and ans[1] == arr[j]

// num inc or denom dec -> fration increases
/*Approach :
1.lo = 0.0 and hi at 1.0
2.calculate mid 
3.define numrtr as 0 and denomrtr as 1
4.loop from least number and if arr[i]/arr[j] is greater then mid then move j till smaller value if found
5.now on smaller add length - j elements to count-> they all will be smaller
6.now if count of smaller fraction is less than req k it means our mid is smaller go for higher mid by lo = mid +1
else hi = mid - 1 if it equal to mid then return ans

arr[] -> 1  2  3  5

    5    3    2    1
1  1/5  1/3  1/2  1/1
2  2/5  2/3  2/2  2/1
3  3/5  3/3  3/2  3/1
5  5/5  5/3  5/2  5/1
in ques -> i > j ->upper part of matrix is req only
if lo =0.0 and hi = 1.0
*/

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double lo = 0.0;
        double hi = 1.0;

        while(lo < hi){
            double mid = (lo + hi)/2;
            int p = 0;
            int q = 1;

            int count = 0;
            int j = 0;
            
            for(int i = 0;i < arr.length;i++){
                while(j < arr.length && arr[i] * 1.0 / arr[j] > mid){
                    j++;
                }
                if(j == arr.length){
                    break;
                }

                count += (arr.length - j);
                //we can not return mid as it is not in array
                //if arr[i]/arr[j] > p/q then update p,q -> closest to mid
                if(p * arr[j] < q * arr[i]){
                    p = arr[i];
                    q = arr[j];
                }
            }
            if(count < k){
                lo = mid;
            } else if(count > k){
                hi = mid;
            } else {
                return new int[]{p,q};
            }
        }
        return null;
    }
}