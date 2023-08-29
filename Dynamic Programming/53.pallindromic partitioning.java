//https://leetcode.com/problems/palindrome-partitioning-ii/
//given a string s, partition it such that every substring of the partion is a pallindrome.
// return the minimum cuts needed for a pallindrome partitioning of s.

/* Approach:



a|bccbc ab|ccbc abc|cbc abcc|bc abccb|c -> total cuts = pehle hisse ko pallindrome me tarike + second + 1(cut)
    \      \       |      /     / 
       a    b      c      c     b    c  -> MCM based as we can see from recursion tree.

       a    b    c      c     b         c

   a   a-0  ab-1 abc   abcc   abccb    abccbc
   
   b   X    b-0   bc-1   bcc   bccb-0   bccbc

   c   X    X     c-0   cc-0    ccb     ccbc

   c   X    X      X     c-0    cb-1     cbc

   b   X    X      X     X      b-0      bc-1

   c   X    X      X     X       X        c-0

   for g = 0 -> no cuts required as only one character.
   for g = 1 -> if character at i == j then no cuts else 1 cut is required
   for g > 1 check char at i and j if it is equal then check if beech wala part is pallindrome or not
    for e.g bccb -> extreames same h and beech wala pallindrome h toh 0 cuts 
*/

class Solution {
    public int minCut(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int g = 1;g < dp[0].length;g++) {
            for(int i = 0,j= g;j < dp[0].length;i++,j++){
                if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 0){
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
                        //loop
                        for(int lk = g,rk = 1;lk >= 1;lk--,rk++){
                            int left = dp[i][j-lk];
                            int right = dp[i+rk][j];
                            dp[i][j] = Math.min(dp[i][j],left + right + 1);
                        }
                    }
                }
            }
        }
        return dp[0][dp[0].length - 1];        
    }
}