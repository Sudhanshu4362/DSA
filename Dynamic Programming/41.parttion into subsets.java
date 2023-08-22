//https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
// given n numbers and k number of subsets,return the number of ways in which these elements can be partioned into non-empty subsets.

/* Approach:
[1234][3 sets] ->1-2-34
                 12-3-4
                 13-2-4
                 1-4-23
                 1-23-4
                 1-24-3
                           1  + 2(k wala case) =3
[123][2 sets] -> (123) -> 12-3,(1-2)3 i.e 13-2,1-23

f(n) = kf(n-1,k) + f(n-1,k-1)
2 cases if n-1 bnde k-1 ke sth h toh add at itis but if (n-1) bnde k ke sath h to product it with k

       0    1     2    3    4    5
   0   0    0     0    0    0    0
   1   0    1     1    1    1    1
   2   0    0     1    3    7    15
   3   0    0     0    1    5    17
   4   0    0     0    0    1    7

   for row 0 and col 0 -> if batna hi nhi h toh dp me zero if partition krne ko log hi nhi toh also 0
   jabtak person target partion se kam h means partion nhi ho skta toh dp me 0 if person = target h toh 1 tarika h 
   else dp me pichli row me pichla col + isi row me pichla col * 
*/
public class Main {
        
    public static long partitionKSubset(int n, int k) {
        if(n == 0 || k == 0 || n < k){
            return 0;
        } else if(n == k){
            return 1;
        }
        
        long[][] dp = new long[n + 1][k + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(j == 1){
                    dp[i][j] = 1;
                } else if(i < j){
                    dp[i][j] = 0;
                } else if(i == j) {
                    dp[i][j] = 1;
                } else {            
                    dp[i][j] = dp[i - 1][j - 1] + j * dp[i - 1][j];
                }
            }
        }
        
        return dp[n][k];
    }
}