// https://leetcode.com/problems/longest-palindromic-substring/ 
// Same as for count ,we have to give largest among them.

/*Approach:
1.loop on gaps strategy as in MCM.
2.for g = 0 -> True 
3.for g = 1 -> check if character at i and j are same character
4.for g > 1 -> check if i == j and middle is also true by checking dp[i+1][j-1]
5.the longest pallindromic sequence will be present at last pallindromic sequence of highest gap.
*/

class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for(int g = 0;g < dp[0].length;g++) {
            for(int i = 0,j = g;j < dp[0].length;i++,j++) {
                if(g == 0){
                    dp[i][j] = true;
                } else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if(dp[i][j]) {//highest gap ka aakhri true
                    res = s.substring(i,j + 1);
                }
            }
        }
        return res;
    }
}