// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/ 
// atmost two transactions allowed.

/* Approach:
Intuition -> try to sell on every day i.e aaj ya aaj se pehle sell kiya hota toh max profit kitna hota 
profit till that day is max of the profits till today(max of profits at each day  is aaj tak ka profit and aaj ka profit is today price - least buying price)
for buying if you buy today then loop from last and sell on next max(aaj ke bad ka max)
Now hamne is din ya isse pehle din tak hi sell ka profit and is din ya is din ke bad buy ka profit nikal liya.we will add these two arrays for each day and return max.
Approach:
   1.first calculate max profit till today -> dps[] -> aaj tak ka profit
   2.initialize a variable lpsf to get least price till today and calculate pist as price[i] - lpsf
   3.fill dps with max of pist vs prev value in dps
   4.now get max profit till today if bought today -> dpb-> aaj ya aaj ke bad kharid ke max profit
   5.initalize a variable mpsf to get max in right and calculate pibt as mpsf - price[i]
   6.fill dpb with max of pibts
   7.again loop and add corresponding dps with dpb and return max of it.

*/

class Solution {
    public int maxProfit(int[] prices) {
        int[] dps = new int[prices.length];// dp for sell
        int lpsf = prices[0];//least price so far
        dps[0] = 0;
        //calculate aaj tak ka max
        for(int i = 1;i < prices.length;i++){
            lpsf = Math.min(lpsf,prices[i]);
            int pist = prices[i]-lpsf;//profit if sold today
            dps[i] = Math.max(dps[i - 1],pist);//aaj tak ka max
        }
        
       int[] dpb = new int[prices.length];//dp for buying 
        dpb[dpb.length - 1] = 0;
        int mpsf = prices[prices.length - 1];// max price so far
        for(int i = prices.length - 2; i >= 0; i --){
            mpsf = Math.max(mpsf, prices[i]);
            
            int pibt = mpsf - prices[i];//profit if buy today
            dpb[i] = Math.max(dpb[i + 1], pibt);//get max buying profit -> aaj ya aaj ke bad khrid ke max profit
        }
        
        int val = 0;
        for(int i = 0; i < prices.length; i++){
            //again loop and add two dp[i] and calculate max profit.
            val = Math.max(dps[i] + dpb[i], val);
        }
        
        return val;
    }
}