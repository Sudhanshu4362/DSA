// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/ 
// atmost k transactions allowed -> return max profit

/* Approach:

prices ->    10  15  17  20  16  18  22
        0    0   0   0    0   0   0   0
        1    0   5   7   10  10  10  12 
        2    0   5   7   
        3    0                          *
        4    0
        Transac.

        if ek bhi transc allowed nhi hoti toh no profit 
        pehle din bhi buy krke sell krege toh koi profit nhi hoga 
        * din tak 3 transac. krte hue kitna max profit -> 1st case is last cell if tino transac. ho gyi h toh agle koi transaction nhi kr skte prev vali hi copy kro but if 2 transc. kri h toh 3 transaction prev row,col-1 pe kr skte h maxp will be but 3sri transac i-1,j-1 se i=1,j=1 tak me ho skti h 
              p t
        i.e P(6,3)= max([5,3] vs [5,2] + 22-18 vs [4,2] + 22-16 vs p[3,2] + 22-20.....)

        day 2 ko 0 vs o + (15-10) day 3 ko 5 vs  2 vs ( 7),day 4 ko  7 vs 0+3 vs 0+5 vs 0+10
*/
// O(N3) Solution
class Solution {
    public int maxProfit(int k, int[] prices) {
       int[][] dp = new int[k+1][prices.length];

       for(int i = 1;i <= k;i++){

        for(int j = 1;j < prices.length;j++){
            //jth day ith transaction profit
            // dp[i][j] = dp[i][j-1];//j-1th day tha hi i transaction ho gyi
            int maxp = 0;
            //uper wali row me loop to get profits till j-1th day
            for(int jj = 0;jj <= j-1;jj++){
                 maxp = Math.max(maxp,dp[i-1][jj] + prices[j] - prices[jj]);
            }
            dp[i][j] = Math.max(maxp,dp[i][j-1]);
        }
       }
       return dp[k][prices.length-1];
    }
}

// O(N2) Solution ->
/*
we will try to overcome the loop running on rows.
jj is varying but we are adding price[j] to every one so directly add it in dp[i][j] = max(maxp + price[j],dp[i][j-1]) and we have already filled dp of dp[i-1][j-1] we only need to minus it with price[j-1]
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0){
            return 0;
        }
        int[][] dp = new int[k + 1][prices.length];
        
        for(int i = 1; i <= k; i++){
            int maxp = Integer.MIN_VALUE;
            
            for(int j = 1; j < prices.length; j++){
                maxp = Math.max(maxp, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(maxp + prices[j], dp[i][j - 1]);
            }
        }
        
        return dp[k][prices.length - 1];
    }
}