// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// fees on selling.
// you cant sell on any day as there is transaction fees on sellings.
/* Approach:
intuition: so at buying we will check if we buy on perticular day then bsp will prev ssp-price[i] and we compare it with our old bsp and in selling we compare old bsp + price[i] - fees vs old ssp.
           
  1.Calculate bought state profit and sell state profit 
  2.get new bsp and ssp buy getting max of ossp-price[i],obsp and obsp - price[i] -fees vs ossp
  3.update our obsp and ossp for each day and return ossp as you will always get maximum in sold state as there is no prfit in holding stokes better is sell.
   days    -> 0   1    2    3     4    5
  price[] ->  1   3    2    8     4    9  transaction fees -> 2
  bsp     -> -1  -1   -1   -1     1    1
  ssp     ->  0   0    0    5     5    8
  
day1-> agar pehle din buy krege to profit nhi rhega loss rhega buying price ka and ssp will be 0
day2-> day 1 ko buy nhi kr skte as lagatar 2 buys is not allowed if is din hi khridte toh -3 ka profit but previous is -1 and -1 is better so day ko buy nhi krege  if sell on day 1 toh 3-2-1 profit hoga which is 0 continiue old 
day3-> buy pe -2 vs day 0 ka -1 so -1 ko continue on buying and on selling 2-2-1 = -1 vs 0 so continue 0
day4-> buy pe -8 vs -1 and selling ka 0 vs 8 - 2 - 1 = 5 profit hoga
*/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0];//
        int ossp = 0;
        for(int i = 1;i < prices.length;i++) {
            int nbsp = Math.max(ossp - prices[i],obsp);
            int nssp = Math.max(obsp + prices[i] - fee,ossp);
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
}