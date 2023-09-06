// https://leetcode.com/problems/distinct-subsequences/ 
// given 2 string s and t, return the no of distinct subseq. of s which equals t.

// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from s.
// 1.RABBbIT 2.RAbBBIT  3.RABbBIT 

/* Approach:
 1. for i == 0 and j == 0 dp[i][j] will be 1 
 2.for i == 0 dp[i][j] = 1 and j == 0 dp[i][j] = 0
 3.now if last character is not same then ans will be without appending that character i.e dp[i][j-1]
 4.if last character is same then ans will be sum of dp[i][j-1] +dp[i-1][j-1]

 s -> abca'b'c'
 t -> abc
   
     X   a    b    c   a'   b'   c'
 X   1   1    1    1   1    1    1  
 a   0   1    1    1   2    2    2
 b   0   0    1    1   1    3    3
 c   0   0    0    1   1    1    4

 if i== 0 and j == 0 -> dp[i][j] = 1
 for i ==  0 -> blank subseq 1 bar sab me h so dp[1][j] = 1
 for j = 0 ->blank se a nhi bna skte h so dp[i][j] = 0
 now else all these positions if last character are not same then uske pichle wala hi continue hoga 
 if last character are same then dp[i][j] = usi row ka pichla col i.e dp[i][j-1] + pichli row ka col i.e dp[i-1][j-1]

 for e.g abcabcd and abc -> [abcabc] me hoga sare subseq as last ch are not same  bcz seq(abcabcd) = seq(abcabc)d
 for same abcc me abc -> [abc]c ab sq(abc) and seq(abc)c me bhi mil skta h i.e ab in abc and add c to it + abc in abc and c nhi lagya 
*/

class Solution {
    int mod = 1000000007;
    public int numDistinct(String s, String t) {
         int[][] dp = new int[t.length() + 1][s.length() + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                } else if(i == 0){
                    dp[i][j] = 1;
                } else if(j == 0){
                    dp[i][j] = 0;
                } else {
                    if(s.charAt(j - 1) == t.charAt(i - 1)){
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i][j - 1]) % mod;
                    } else {
                        dp[i][j] = (dp[i][j - 1]) % mod;
                    }
                }
            }
        }
        
        return dp[t.length()][s.length()];
    }
}