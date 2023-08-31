// https://leetcode.com/problems/palindrome-partitioning/ 

// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

//  Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

/* Approach:



   Recursive approach:
                   abccb -> ki pp dedo and c uske piche add
                    |c->c ek pallindrome h
   a  b   c   c  b  c
    
    bc -> not pallindrome so no call
    cbc -> is pallindrome so get pallindromic partitioning of abc and add cbc 
    dp:
          a     b      c       c      b       c

    a    a-T   ab-F   abc-F   abcc-F  abccb-F abcbc-F

    b     X     b-T    bc-F    bcc-F   bccb-T  bccbc-F

    c     X      X      c-T     cc-T    ccb-F   ccbc-F   
     
    c     X      X       X       c-T     cb-F    cbc-T  

    b     X      X       X        X       b-T     bc-F

    c     X      X       X        X       X        c-T

    for g = 0 -> all True
    for g == 1 -> if ch. are same then pallindrome
    for g > 1  -> if if extreames are not same then not pallindrome else if middle part is pallindrome then pallindrome.

    now for every pallindrom call the recursion function as discussed.(end points se last ch consdered.)
    i ko j(end pt) se start and check every pallindrome
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
    public List<List<String>> helper(String s, int j, List[] dp){
        if(j < 0){
            List<List<String>> bres = new ArrayList<>();
            List<String> blist = new ArrayList<>();
            bres.add(blist);
            return bres;
        }
        if(dp[j] != null){
            return (List<List<String>>)dp[j];
        }
        List<List<String>> mres = new ArrayList<>();
        for(int i = j;i >= 0;i--){ //i ko j(end pt) se start and check every pallindrome
            if(ip[i][j] == true){
                String pallin = s.substring(i,j+1);
                List<List<String>> rres = helper(s,i-1,dp);
                for(List<String> rlist : rres){
                    ArrayList<String> mlist = new ArrayList<>(rlist);
                    mlist.add(pallin);
                    mres.add(mlist);
                }
            }
        }
        dp[j] = mres;
        return mres;
    }
    public List<List<String>> partition(String s) {
        IsPalindrome(s);
        List<List<String>>[] dp = new List[s.length()];
        return helper(s, s.length() - 1, dp);
    }
}