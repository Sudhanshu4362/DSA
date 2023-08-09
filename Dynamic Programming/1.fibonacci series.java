// Link -> https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1

// fibonacci -> 0 1 1 2 3 5 8 13......

/* Approach:
1.Recursioon:
fib(n) = fib(n-1) + fib(n-2)

  1
  |
  2-----0
  |
  3-----1            1
  |                  |
  4-----2            2---1
  |                  |
  5-----3-           3--1    1
  |                  |       | 
  6------------------4--------2-----1
  For whole recursion we are calculating same thing multiple time for e.g 4 ka fib-2 times,3 ka 3times,2 ka 5 time 
  so we can store values of fib.for that we have already done calculations
             0 1 2 3 4 5 6
  strg[] -> [0,1,1,2,3,5,8]

Tabulation -> first think where problem is less
dp[0] = 0,dp[1] = 1 
        0 1 2 3 4 5 6
dp[] = [0,1,1,2,3,5,8]
    ------------------->direction of dp
    in tabulation ->1.storage ka meaning i.e what to store where
                    2.direction -> choti problem kidhr h and badi kidhr
                    3.travel and solve
*/
//recursion code
class Solution {
    static int nthFibonacci(int n){
      if(n == 0 || n == 1){
        return n;
      }
      int fnm1 = nthFibonacci(n-1);
      int fnm2 = nthFibonacci(n-2);
      int fn = fnm1 + fnm2;
      return fn;
    }
}
//dp-memoization code
class Solution {
    static int nthFibonacci(int n){
      int fn = fib_memo(n,new int[n+1]);
      return fn;
    }
    static int fib_memo(int n,int[] strg){
        int MOD = 1000000007;
        if(n == 0 || n == 1){
        return n;
      }
      if(strg[n] != 0){
        // if result already we have dont do below calculations 
        return strg[n];
      }
      int fnm1 = fib_memo(n-1,strg) % MOD;
      int fnm2 = fib_memo(n-2,strg) % MOD;
      int fn = (fnm1 + fnm2) % MOD;
      strg[n] = fn;
      return fn;
    }
}

//dp-tabulation
class Solution {
    static int nthFibonacci(int n){
      int fn = fib_dp(n,new int[n+1]);
      return fn;
    }
    static int fib_memo(int n,int[] dp){
        int MOD = 1000000007;
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2;i <= n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        return dp[n];
    }
}