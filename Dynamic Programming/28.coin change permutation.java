
// coins ->2,3,5,7 -> return no of way to pay 10rs using these coins -> permutaions (25,52 are diff in Permutation)

/* Approach:
1.create dp array of target + 1 size.
2.dp[0] = 1
3.loop on target from 1 to target
3.inside target loop loop on coins if t-coin>= 0 then add in dp[t] to dp[t-coin].
        0   1  2  3  4   5  6    7
  dp -> 1   X  1  1  1   3  2    6  
        .      2  3  22  32 222  322
                         23 33   232,52,223
                         5       25,7
    1 cant be paid
    2 can be paid using coin 2
    3 can be paid if we use coin 2 but remaining 1 cant be paid next we check if 3 se pay kr to 0 can be paid
    4 ke liye 2,3 use ho skte if we use coin 2 we get 2 and remaining 2 also can be paid so 4 can be paid using
    coin 2 but if we use coin 3 we cant pay remaining 1.
*/  

int[] dp = new int[tar + 1];
dp[0] = 1;
for(int t = 1;t <= tar;t++){
    for(int coin : coins){
        // for every coin check if coin is less then target or not bcz greater coin cant be used for lesser target
        if(t - coin >= 0){
            dp[t] += dp[t - coin];
        }
    }
}
return dp[tar];