// https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
// given N friends, each one can pair up or remain single .each friend can be only paired up only once. find out no of ways in which friends can remain single or can be paired up.

/* Approach:


      \|/   \/     \/    \/
      234   34     24    23   -> 4 + 2 + 2 + 2 = 8 => 4 + 3.2 => f(4) = f(3) + (i-1)f(2)
      1-\  12|   13/    /14
         1   2    3    4

         12 -> ya toh 1-2 alag alag ya 12 sath -> base case
         123-> 1 akela ->23 jitne tariko se pair ho ya 12 ke sath pair ho to 3 rhega(pair hone ko) ya 13 ke sath toh 2 rhega[1-2-3,1-23,12-3,13-2]
         for n -> f(n) = f(n-1) + (i-1)f(n-2)
                        f(n-1) -> n wala alag rhta h
                        f(n-2) -> 2 log pair bnate h -> (n-2) remaining * (n-1) calls
*/

class Solution
{
    public long countFriendsPairings(int n) { 
        long[] dp = new int[n+1];
        int MOD = 1000000007;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= dp.length;i++){
            dp[i] = (dp[i-1] + (i-1) * dp[i-2]) % MOD;
        }
        return dp[n];
    }
}    
 