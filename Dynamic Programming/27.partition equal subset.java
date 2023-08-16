// EXTENSION OF TSS
// find if array can be partitioned into two new subsets such that the sum of elements in both sets subsets is equal to the sum of

/* 
1.take total sum of array
2.if sum is odd then partion is not possible but if sum is even then partition is possible
3.use Target sum subset approach if sum/2 sum is possible then return true.
*/

class Solution {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        if(sum % 2 == 1) {
            return false;
        }
        int tar = sum/2;
        // TSS code
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        for(int i = 0;i < dp.length;i++) {
            for(int j = 0;j < dp[0].length;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int curr = arr[i - 1];
                        if(j >= curr) {
                            if(dp[i - 1][j - curr] == true) {
                                dp[i][j] = true;
                            } else {
                                dp[i][j] = false;
                            }
                        }
                    }
                }
            }
        }
        return dp[arr.length][tar];
    }
}