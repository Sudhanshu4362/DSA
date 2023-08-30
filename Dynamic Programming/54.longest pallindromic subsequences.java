// https://leetcode.com/problems/longest-palindromic-subsequence/ 
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

/* Approach:
 1. for g = 0 -> ans will be 1
 2. for g = 1 -> if c1 == c2 then ans will be 2 otherwise 1.
 3. for g > 0 -> check if last character matches or not 
    if c1 == c2 -> then max will be 2 + len(middle)
    if c1 != c2 -> then take max of prefix seq and suffix seq. i.e max(i+1,j and i,j-1)

set of subsequences of abcd
            s(1) - s(bc) ->  --,-c,b-,bc -> bc ke subsequences-> sq(m) -> n-2 le liya and aagey piche ch lga liye.
            s(2) - as(bc) ->a--,a-c,ab-,abc -> bc ke subsequences ke aage a lga do -> c1sq(m)
 s(abcd) -> s(3) - s(bc)d -> --d,-cd,b-d,bcd ->bc ke subsequences ke piche d  -> sq(m)c2
            s(4) - as(bc)d ->a--d,a-cd,ab-d,abcd -> bc ke subsequences ke aage a piche d-> c1seq(m)c2

    if c1 == c2 then                            if c1 != c2 then
    ans = 2 + len(middle)                       s4 -> no pallindrome => s4 = 0 -> ans will be in s1,s2,s3
    in s4 contains all the seq of s1            ans = max(l(mc2),l(c1m)) i.e (suffix(i+1,j),prefix(i,j-1))
    but 2 size bigger and  for 2,3 they         bcz mc2 = sq(m) and sq(m)c2 and c1m = sq(m) and seq(mc1)
    repeat in s4                                           s(1)      s(3)              s(1)       s(3)
    so max will be 2+ midddle                    inhi me se dhudna tha max

     a      b     c      k      b     c   

 a   a-1   ab-1  abc-1  abck   abckb  abckbc

 b    X    b-1   bc-1   bck-1  bckb-3 bckbc
 
 c    X     X    c-1     ck-1  ckb     ckbc-3

 k    X     X     X       k-1  kb-1     kbc-1
 
 b    X     X     X        X    b-1     bc-1

 c    X     X     X        X     X       c-1

 for e.g bckb -> c1 == c2 -> ans will be 2 + len(ck) = 2+1=3
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int g = 0;g < dp[0].length;g++) {
            for(int i = 0,j = g;j < dp[0].length;i++,j++){
                if(g == 0){
                    dp[i][j] = 1;
                } else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j)? 2 : 1;
                } else {
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][dp[0].length - 1];
    }
}