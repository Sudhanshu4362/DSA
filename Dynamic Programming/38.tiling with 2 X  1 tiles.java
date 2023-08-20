// https://practice.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

//given board of 2 * n size return the ways of tiling it with 2*1 tiles.
/* Approach:


  There are two ways of tiling it one is vertically and horizontally 
  if vertically-> then it will occupy whole heieght i.e 2 but width will be only one so rem. will be n-1 i.e ways to tile it will be dp[n-1]
  if horizontally -> then it will occupy 1 height but 2 width so rem.height will be 1 and width will be n-2 so remaing height can be tiled in only one way and width will be dp[n-2] 
*/


class Solution {
    static Long numberOfWays(int n) {
        // code here
        Long[] dp = new Long[n+1];
        int MOD = 1000000007;
        dp[0] = 1L;
        dp[1] = 1L;
        for(int i = 2;i <= n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        return dp[n];
    }
};