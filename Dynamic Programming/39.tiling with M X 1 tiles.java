// https://practice.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles0509/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// m * n floor -> m * 1 tiles 

/* Approach:
  
  here are two ways of tiling it one is vertically and horizontally 
  if vertically-> then it will occupy whole heieght i.e m but width will be only one so rem. will be n-1 i.e ways to tile it will be dp[n-1]
  if horizontally -> then it will occupy 1 height but m width so rem.height will be m-1 and width will be n-m so remaing height can not be tiled so only one way  and width will be dp[n-m] 
*/

class Solution
{
    public int countWays(int n, int m)
    {
        int[] dp = new int[n+1];
        for(int i = 1;i <=n;i++){
            if(i < m){
                dp[i] = 1;                          
            } else if(i == m){
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
    }
}
