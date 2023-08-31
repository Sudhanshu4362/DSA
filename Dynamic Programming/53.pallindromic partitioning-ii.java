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

// O(N^2) Solution
/* Approach:
1. functtion to check ispallindrome[as discussed]
2. dp[0] = 0 as single ch is pallindrome and no cuts will be req.
3. dp[1] = 0 if both ch are same else 1 cuts
3. onwards we have j at 2 and i at j and move i from j to 0 and check cuts required for all pallindromes and take min of all.
4. to calculate number of cuts => 1 + dp[i-1] (1 apna cut + previous minimum cuts req.)
 


 for e.g abccbc
          a b c c b c
 dp[] -> [0,1,2,2,2,2]
 a-0
 ab - if ch same then 0 cut else 1 cut
 at abc -> j at c and start i from j and calculate cuts for each i,j i.e for c as bc and abc are not pallindrome we will not take that so ans will min of all i.e  dp[i-1] + 1 = 1+1(c ke liye cut) = 2
 for abcc -> start from 2nd c i.e i and j at c [cuts for this will be 1 + dp[i-1] = 1+2=3] next is j at second c and i at 1st so cuts will be 1 + dp[i-1] = 1+1=2 which is minimum.
*/

class Solution {
    boolean[][] ip;
    void IsPalindrome(String s) {
        ip = new boolean[s.length()][s.length()];
        for(int g = 0;g < ip[0].length;g++){
            for(int i = 0,j = g;j < ip[0].length;i++,j++){
                if(g == 0){
                    ip[i][j] = true;
                } else if(g == 1){
                    ip[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    ip[i][j] = s.charAt(i) == s.charAt(j) && ip[i+1][j-1] == true;
                }
            }
        }
    }
    public int minCut(String s) {
        IsPalindrome(s);
        int[] dp = new int[s.length()];
        dp[0] = 0;
        // dp[1] = s.charAt(0) == s.charAt(1)? 0:1;

        for(int j = 1;j < dp.length;j++){
            dp[j] = j;
            if(ip[0][j] == true){ // 0 se j puri string hi pallindrome h toh no cuts req.
                dp[j] = 0; 
            } else {
                for(int i = j;i > 0;i--){
                if(ip[i][j] == true){
                    dp[j] = Math.min(dp[j],dp[i-1] + 1);
                }
            }
            }
        }
        return dp[dp.length - 1];        
    }
}