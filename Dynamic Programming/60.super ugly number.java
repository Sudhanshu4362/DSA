// https://leetcode.com/problems/super-ugly-number/ 
// A super ugly number is a positive integer whose prime factors are in the array primes.
// Given an integer n and an array of integers primes, return the nth super ugly number. 

// Input: n = 12, primes = [2,7,13,19]
// Output: 32
// Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given 
// primes = [2,7,13,19].

/* Approach:
intuition-> we cant make pointers for each prime instead  we make a pointer array. 

Approach:
1.Maintain a pointer array
2.loop on primes and multiply each with their corresponding number in dp array
3. again loop to increment the pointer.

           3,5,7,11
dp[] -> [X   1        3      5      7]
                      3,5,7
*/ 

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        int[] idxs = new int[primes.length];//idex array to store idx of primes
        Arrays.fill(idxs,1);
        for(int i = 2;i < dp.length;i++) {
            long ans  = Integer.MAX_VALUE;
            for(int j = 0;j < primes.length;j++) {
                int prime = primes[j];
                int idx = idxs[j];

                ans = Math.min(ans,dp[idx] * prime);
            }
            //loop for incrementing the idx or pointer
            for(int j = 0; j < primes.length; j++){
                int prime = primes[j];
                int idx = idxs[j];

                if(ans == dp[idx] * prime){
                    idxs[j] = idx + 1
                }
            }
            dp[i] = ans;
        }
        return (int)dp[n];
    }
}