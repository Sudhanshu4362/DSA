// https://leetcode.com/problems/palindromic-substrings/   ->  count 

// Given a string s, return the number of palindromic substrings in it.

// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

/*Approach:
1.loop on gaps strategy as in MCM.
2.for g = 0 -> True 
3.for g = 1 -> check if character at i and j are same character
4.for g > 1 -> check if i == j and middle is also true by checking dp[i+1][j-1]
5.for every true res++ 

      a     b     c       c       b         c
  a  a-T   ab-F  abc-F   abcc-F  abccb-F  abccbc-F

  b  X     b-T    bv-F    bcc-F   bccb-T   bccbc-F

  c  X     X      c-T     cc-T     ccb-T    ccbc-F

  c  X     X       X       c-T      cb-F     cbc-T

  b  X     X       X        X       b-T      bc-F

  c  X     X       X        X        X         c-T

  for g = 0 -> only one character means pallindrome so store true
  for g = 1 -> only two characters if it matches then store True
  for g > 1 check if extreams equal i.e i==j and beech ke character pallindrom ho
  for e.g cbc extreams are equal then check if b is pallindrome or not to check it go to next row and prev col.
  for ccbc c and c are same and cb i.e pichla row and pichla col pe false h toh ccbc is also not pallindrome
*/


class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for(int g = 0;g < dp[0].length;g++) {
            for(int i = 0,j = g;j < dp[0].length;i++,j++) {
                if(g == 0){
                    dp[i][j] = true;
                } else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if(dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
}