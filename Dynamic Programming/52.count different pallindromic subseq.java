// https://leetcode.com/problems/count-different-palindromic-subsequences/ 

// same as  prev but we have to return distinct i.e duplicates not allowed
// Input: s = "bccb"
// Output: 6
// Explanation: The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
// Note that 'bcb' is counted only once, even though it occurs twice.

/* Approach:
 1. for g = 0 -> ans will be 1
 2. for g = 1 -> ans will be 2
 3. for g > 0 -> check if last character matches or not 
     if c1 != c2 -> get prefix from i,j-1 and suffix as i+1,j and middle part as i+1,j-1 then add p + s -m
     if c1 = c2 -> additional 3 cases
      1. if middle me same character h as extremes so ans will be 2 * middle + 2, (i+1,j-1) -> middle 
      2. if middle me 1 same character h as extremes so ans will be 2 * middle + 1
      3.if middle me 1 se jayda same character h as extremes so ans will be 2 * middle  - dps(m')

 set of subsequences of abcd
            s(1) - s(bc) ->  --,-c,b-,bc -> bc ke subsequences-> sq(m) -> n-2 le liya and aagey piche ch lga liye.
            s(2) - as(bc) ->a--,a-c,ab-,abc -> bc ke subsequences ke aage a lga do -> c1sq(m)
 s(abcd) -> s(3) - s(bc)d -> --d,-cd,b-d,bcd ->bc ke subsequences ke piche d  -> sq(m)c2
            s(4) - as(bc)d ->a--d,a-cd,ab-d,abcd -> bc ke subsequences ke aage a piche d-> c1seq(m)c2

c(abcd) depends  on s(abcd) -> s(1)s(2)s(3)s(4) 

if c1 != c2 then                
s4 = 0 => s1+s2+s3 as first and last charctrs are not equal
s1+s2+s3+s1-s1
(s1+s2) + (s1+s3) -s1
1+s2 -> is seq of all the suffixes ,s1+s3 -> prefix
s(m)c2                              c1s(m)
c(i+1,j) + c(i,j-1) - c(i+1,j-1)
dps(mc2) + dps(c1m) - dps(m) 
 if c1 == c2
 then 3 cases              
 1.no a in middle part     2. 1 a in middle part    3. 1 se jayada a in middle part
 a------a                   a---------a                   a-------------a
    m                            m                              m 
 
 2+dps(m) +2                    2dps(m) + 1                     2dps(m) - dps(m') -> m' is middle of ander wala a
 
 dps -> distinct pallindromic sequences

  
       a    b    a     b        d       c

   a  a-1  ab-2 abc-3 abcc-4  abccb-7 abccbc-9
   
   b   X   b-1  bc-2   bcc-3   bccb-6   bccbc-8

   c   X    X     c-1   cc-2    ccb-3    ccbc-5

   c   X    X      X     c-1    cb-2      cbc-4

   b   X    X      X     X      b-1       bc-2

   c   X    X      X     X       X          c-1

  for e.g cbc -> extreams are same but beech me b nhi h toh first case and hence dp[i][j] will be 2 * 1 + 2 = 4
  for e.g ccbc -> extreams are same and beech me 1 c h toh 2nd case and dp[i][j] will be 2*2 + 1 = 5
  for e.g ccaacbc -> extreams are same and beech me 2 c h toh 2 *(caacb) - dps(aa)
  to get ander wale aa 
  get next array and store all of characters next repeatitions i.e c -> next c -> next c -> end
  and previous array me last se previous repeatitions ke index honge c -> prev.c -> prev.c -> null
         n         p
   a  b  a  c  d   a  e  a
   i                     j

 check i ka next and j ka previous
 next and previous are not same means multiple a's -> 2 dps(i+1,j-1) - dps(n+1,p-1)
                                                                   i       j
 if a ka next is greater then j ka previous means there is no a -> a b c d a
                                                                   p       n
                                                               i     n        j
 if i ka next is same as j ka previous means there is 1 a.     a  b  a  c  d  a
                                                                     p 
 */

class Solution {
    long MOD = 1000000007;
    public int countPalindromicSubsequences(String s) {
        long[][] dp = new long[s.length()][s.length()];

        int[] prev = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch) == false){
                prev[i] = -1;// abhi tak nhi aaya
            } else {
                prev[i] = map.get(ch);//pehle aa chuka h 
            }
            map.put(ch,i);
        }

        int[] next = new int[s.length()];
        map.clear();
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch) == false){
                next[i] = -1;// abhi tak nhi aaya
            } else {
                next[i] = map.get(ch);//pehle aa chuka h 
            }
            map.put(ch,i);

        }

        for(int g = 0; g < dp[0].length; g++) {
            for(int i = 0,j = g;j < dp[0].length;i++,j++){
                if(g == 0){
                    dp[i][j] = 1;
                } else if(g == 1){
                    dp[i][j] = 2;
                } else {
                    if(s.charAt(i) != s.charAt(j)){
                        dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] + MOD) % MOD;
                    } else {
                        int n = next[i];
                        int p = prev[j];
                        if(n > p){
                            //starting ka next > ending ka prev
                            dp[i][j] = (2 * dp[i+1][j-1] + 2) % MOD;
                        } else if(n == p){
                            dp[i][j] = (2 * dp[i+1][j-1] + 1) % MOD;
                        } else{
                            dp[i][j] = (2 * dp[i+1][j-1] - dp[n + 1][p - 1] + MOD) % MOD;
                        }
                    }
                }
                dp[i][j] =  (dp[i][j]+MOD)%MOD;  
            }
        }
        return (int)dp[0][dp[0].length-1];
    }
}