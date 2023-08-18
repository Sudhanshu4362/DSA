// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// infinite transaction is allowed and two transactions cant overlap

/* Approach:
Intituion -> Every incresing seq will give profit and if price drop then sell it and calculte profits for each and add it to our profit
   1.Initial bd and sd at start
   2.traverse array and if price is increasing then move selling pt to get max profit sd++
   3.if price is less then it means drop in price so calculate profit at that day and update bp=sd=i
   4.for last seq we dont have any drop so add it manually 
*/

class Solution {
    public int maxProfit(int[] prices) {
        int bd = 0;//buying day
        int sd = 0;//selling day
        int profit = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] >= prices[i - 1]){
                //price increasing move selling point
                sd++;
            } else {
                //price decreasing -> sell it
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        //for last sequence -> if drop na mile toh calculate it manually
        profit += prices[sd] - prices[bd];
        return profit;
    }
}