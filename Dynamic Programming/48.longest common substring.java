// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1 
// given two strings find the length of the longest common substring

// LCS based group

// Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
// Output: 4
// Explanation: The longest common substring is "CDGH" which has length 4.

/*Approach:
Intuition -> get suffix and match the suffixes of the both strings
  1.for i == 0 and j == 0 fill dp with zero.
  2.
substrings of ABCDGH                            substrings of ACDGHR
a                                               a     
ab        b                                     ac      c  
abc       bc        c                           acd     cd     d
abcd      bcd       cd     d                    acdg    cdg    dg    g  
abcdg     bcdg      cdg    dg    g              acdgh   cdgh   dgh   gh   h
abcdgh    bcdgh     cdgh   dgh   gh   h         acdghr  cdghr  dghr  ghr  hr   r

common -> a,c,cd,cdg,cdgh,d,dg,dgh,g,gh,h -> longest is cdgh

dp ->

     X   a    c    d    g    h   r
 X   0   0    0    0    0    0   0
 a   0   1    0    0    0    0   0
 b   0   0    0    0    0    0   0
 c   0   0    1    0    0    0   0
 d   0   0    0    2    0    0   0
 g   0   0    0    0    3    0   0 
 h   0   0    0    0    0    4   0

 a and a ka suffix, a and ac ka suffix and so on.. if last character not matches then no common suffix
 if last character matches then go one step back and add + 1 to it.
 get last character as s1.charAt(i-1) and s2.charAt(j-1) if it matches then update dp[i][j] with 1+dp[i-1][j-1]

for e.g abcdg and acdg ke liye dp bhare toh last charcter matches thn get longest common suffix of abcd and acd and add +1 to it i.e pichla row and pichla column.
*/

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int res = 0; 
        int[][] dp = new int[S1.length() + 1][S2.length() + 1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    res = Math.max(res, dp[i][j]);
                } 
            }
        }
        return res; 
    }
}