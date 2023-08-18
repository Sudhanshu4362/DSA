// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//given array price and price[i] contains price of stock on ith day, maximize the profit by selecting a day to buy it and sell on another day return the maximum profit -> only one buy and sell allowed.

/* Approach:
  Intitution: We will try to sell everyday and calculate the profit and we will update our buying price to that day when there is profit i.e we will buy when price is minimum
  
  1. Intial buying price is price[0].
  2.loop on price and update buying price to min of current bp and price[i]
  3.calculate the pist(profit if sell today) buy price[i]-bp
  4.update profit buy taking max of all pist.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int bp = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            bp = Math.min(bp,price[i]);
            int pist = price[i]-bp;
            profit = Math.max(profit,pist);
        }
        return profit;
    }
}