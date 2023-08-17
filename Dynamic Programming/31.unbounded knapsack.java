// https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// slight change from prev. we can use one items any number of times
//coin change combination like
/* Approach:
1.create a 1D dp array with cap + 1 size
2.loop on 1 to dp.lngth and nested loop on wts 
3.if i is sufficient the update dp with max of prev dp[i] and dp[i-wt] + curr value.

  val -> 15 14 10 45 30    bag capacity -> 7kg return max value created val@wts
  wt ->   2  5  1  3  4  

     0    1    2            3     4    5    6    7
     0    10   20(15v20)    45    55   65   90   100
          10/1   15@2 vs    45@3  45@3
                 2*10@1           10@1

    0 pe 0 and 1 pe 10 hi option 10
    2 kilo ke bag me if we use 1 then we will be left with 1 and reuse 10 you get max wt to 20 corresponding to 15
    3 kilo ke bag me if we use 10 3 times we get 30 but if we use 10 and 15 then we get 25 but with only 3 we get45

*/
class Solution{
    static int knapSack(int N, int W, int value[], int wts[])
    {
        int[] dp = new int[W + 1];
        for(int i = 1; i <dp.length; i++){
            for(int j = 0;j < wts.length;j++){
                int wt = wts[j];
                int val = value[j];

                if(i >= wt){
                    //if sufficient then get max from dp[i] and i-wt + val for every wts.
                    dp[i] = Math.max(dp[i], dp[i - wt] + val);
                }
            }
        }
    }
}