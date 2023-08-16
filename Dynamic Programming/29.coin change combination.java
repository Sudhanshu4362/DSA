// 
// coins ->2,3,5,7 -> return no of way to pay 10rs using these coins -> combination (25,52 are same in comb.)

/* Approach:
1.create dp array of target + 1 size.
2.dp[0] = 1
3.here first choose coin and loop on all target to avoid permutation as we are not using that coin again

        0   1  2  3   4   5    6    7
  dp -> 1   X  1  1   1   2    2    3  
  2->   .      2      22      222
  3->              3      23   33   223
  5->                      5         25
  7->                                 7
    
    pure array me check impact of coins in whole array
*/  

int[] dp = new int[tar + 1];
dp[0] = 1;
for(int coin : coins){
    for(int t = 1;t <= tar;t++){
    // for every coin check if coin is less then target or not bcz greater coin cant be used for lesser target
        if(t - coin >= 0){
            dp[t] += dp[t - coin];
        }
    }
}
return dp[tar];