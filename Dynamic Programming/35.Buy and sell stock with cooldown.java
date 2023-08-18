// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

//After selling stock you can't buy stock on next day.

/* Approach: 
Intuition:Maintain one more state cooldown state with bs and selling state
calculate nbsp as max of prev vs old selling cooldown state - price[i] as you cant buy after sell wait for cooldown
calculate nssp as max of prev vs old bsp + price[i].
calculate ncsp as max of old ssp and old scp.

 flow -> bs-> ss -> cs -> bs -> ss -> cs....
   1.initialize obsp,ossp,oscp
   2.calculate nbsp,nssp,ncsp as discussed above
   3.update all state
   4.return ossp

   day       0      1      2      3      4      5
  price[] ->  12    10     15     17     20     16
    bs    -> -12   -10    -10    -10    -10    -10 
    ss    ->  0     0      5      7      10     10
    cs    ->  0     0      0      5      7      10
*/
class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0];
        int ossp = 0;
        int oscp = 0;
        for(int i = 1;i < prices.length;i++) {
            int nbsp = Math.max(oscp - prices[i],obsp);
            int nssp = Math.max(obsp + prices[i],ossp);
            int ncsp = Math.max(ossp,oscp);
            obsp = nbsp;
            ossp = nssp;
            oscp = ncsp;
        }
        return ossp;
    }
}
