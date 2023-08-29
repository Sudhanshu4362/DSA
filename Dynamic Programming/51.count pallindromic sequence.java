// https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1 
// find how many pallindromic subsequences can be formed in given string 

/* Approach:
 1. for g = 0 -> only one character -hence 1
 2.for g > 0 -> check if last character matches or not 
     if c1 == c2 -> get prefix from i,j-1 and suffix as i+1,j and add them + 1
     if c1 != c2 -> get prefix from i,j-1 and suffix as i+1,j and middle part as i+1,j-1 then add p + s -m

set of subsequences of abcd
            s(1) - s(bc) ->  --,-c,b-,bc -> bc ke subsequences-> sq(m) -> n-2 le liya and aagey piche ch lga liye.
            s(2) - as(bc) ->a--,a-c,ab-,abc -> bc ke subsequences ke aage a lga do -> c1sq(m)
 s(abcd) -> s(3) - s(bc)d -> --d,-cd,b-d,bcd ->bc ke subsequences ke piche d  -> sq(m)c2
            s(4) - as(bc)d ->a--d,a-cd,ab-d,abcd -> bc ke subsequences ke aage a piche d-> c1seq(m)c2


   c(abcd) depends  on s(abcd) -> s(1)s(2)s(3)s(4)

    if c1 == c2                                     if c != c2 then                
    s1+s2+s3+s4                                   s4 = 0 => s1+s2+s3 as first and last charctrs are not equal
    if c1 == c2 then s4 = s1+1                       s1+s2+s3+s1-s1
    bcz s4 me jitne pallindrom honge utne hi s1       (s1+s2) + (s1+s3) -s1
    me honge + 1 extra for jisme koi chr nhi aata      s1+s2 -> is seq of all the suffixes ,s1+s3 -> prefix
    => 2s1+s2+s3                                        s(m)c2                              c1s(m)
    (s1+s2) + (s3+s1) + 1                               c(i+1,j) + c(i,j-1) - c(i+1,j-1)
    c(i+1,j) + c(i,j-1) + 1

    c1       m          c2
    i                    j
         (j-1)*(i+1)
   
       a    b    c     c        b       c

   a  a-1  ab-2 abc-3 abcc-5  abccb-10 abccbc-16
   
   b   X   b-1  bc-2   bcc-4   bccb-9   bccbc-15

   c   X    X     c-1   cc-3    ccb-4    ccbc-10

   c   X    X      X     c-1    cb-2      cbc-5

   b   X    X      X     X      b-1       bc-2

   c   X    X      X     X       X          c-1

   for abc -> c1 != c2 -> prefix+suffix-m -> ab+bc-b -> 2 + 2 - 1 = 3
*/

class Solution
{
    long MOD = 1000000007;
    long countPS(String str)
    {
        long[][] dp = new long[str.length()][str.length()];
        for(int g = 0;g < dp[0].length;g++){
            for(int i = 0,j = g;j < dp[0].length;i++,j++){
                if(g == 0){
                    dp[i][j] = 1;
                } else {
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = (dp[i+1][j] + dp[i][j-1] + 1) % MOD;
                    } else {
                        dp[i][j] = (dp[i+][j] + dp[i][j-1] - dp[i+1][j-1]) % MOD
                    }
                }
            }
        }
        return dp[0][dp[0].length - 1];
    }
}