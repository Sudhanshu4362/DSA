
// return number of ways to climb stairs

/* Approach:


      d
   m/ n|  \p ways
  i1  i2  i3
   \  |  /
      s
      source to detination jane ke tarike-> m + n + p ways
      1->0 -> 1 way,2->0-> 2 way(11,20),
      3->0 -> 4 ways (111,12,21,30)
      4->0 -> 7 ways(1111,112,121,13,211,22,31)
               0 1 2 3 4 5  6
      strg -> [1,1,2,4,7,13,24]
      choti problem - 0-0 jana,badi problem 6 -> 0
*/

class Solution {
    public int climbStairs_memo(int n,int[] strg) {
       if (n == 0) {
            return 1;
        } else if(n < 0){
            return 0;
        }

        if(strg[n] != 0){
            return strg[n];
        }
        int csm1 = climbStairs_memo(n-1,strg);
        int csm2 = climbStairs_memo(n-2,strg);
        int path = csm1 + csm2+ csm3;
        strg[n] = path;
        return paths;
    }
}

class Solution {
    public int climbStairs(int n) {
       int[] dp = new int[n + 1];
       dp[0] = 1;
       for(int i = 0;i <= n;i++){
        if(i-1 >= 0){
            dp[i] += dp[i-1];
        }
        if(i-2 >= 0){
            dp[i] += dp[i - 2];
        } 
       }
       return dp[n];
    }
}