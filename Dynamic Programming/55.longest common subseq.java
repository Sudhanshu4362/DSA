// https://leetcode.com/problems/longest-common-subsequence/ 
// Given two strings text1 and text2, return the length of their longest common subsequence.

// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

/* Approach:
Intuition -> longest common subsequence of s1,s2 depends on cartesian product of sq(s1) * sq(s2). -> for me for
1. start loop from last and last row and col ans will be 0.
2. now check if c1 == c2 or not
   if c1 == c2 -> ans will be 1 + lcs(r1,r2) i.e 1 + dp[i+1][j-1] (middle part)
   if c1 != c2 -> ans will be max(lcs(r1,s2),lcs(s1,r2)) i.e max(suffix,prefix) i.e max(dp[i+1][j],dp[i][j-1])

  s1 = c1r1[c1-first ch, r1 - rest ch.]
  s2 = c2r2
  lcs(s1,s2) -> sq(s1) * sq(s2) => seq(r1) -> seq(r2) and c1sq(r1) -> c2sq(r2) inka cartesian product
            cartesian prod
            sq(r1) * sq(r2)
            sq(r1) * c2seq(r2) -> ans inhi me hoga 
            c1sq(r1) * seq(r2)
            c1sq(r1) * c2seq(r2)

    if c1 == c2                             if c1 != c2
    ans hamesha s4 me hoga                  s4 = 0 bcz last ch. mismates => s1+s2+s3
    1 wale sare repeat in s4 and len + 1    1,2,3 ka max = max(12,13)
    ans = 1 + l(r1,r2)                      max(l(r1,s2),l(s1,r2))

      a    b     c     d     .

  a   3    2     1     1     0

  e   2    2     1     1     0

  b   2    2     1     1     0

  d   1    1     1     1     0

  .   0    0     0     0     0
  meaning at 0,0 -> pure abcd ka aebd me lcs -> badi problem,choti problem on last kuch nhi ka kuch nhi ke sath lcs
  0,1 ->bcd ka aebd me lcs , 0,3 -> d ka aebd me lcs 
*/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = dp[0].length - 2;j >= 0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j],dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}