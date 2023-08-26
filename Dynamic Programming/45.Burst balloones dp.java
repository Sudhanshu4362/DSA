// https://leetcode.com/problems/burst-balloons/ 
// n balloons[0 to n] each ballone is painted with  a no on it represented by array nums your task is to burst the ballons 
// bursting ith ballone will give nums[i-1]*nums[i]*nums[i+1] coins .if i-1,i+1 goes out of bounds of array then treat is there is a ballone painted 1. return the max coins.
/* Approach:
SAME AS MCM                      
 for 231 ballones ->   2 3 1 ko phodne ke 6 tarkike h(permutaion)
                       6/3 6\2   3 ko phoda toh 6 rs mile and 21 bche rh gye
                      21    31
                    2/2     3\3
                    1         1
                   1/1        1\1
                   total->9    total ->10 

                   x ball y -> cost of ball -> x*ball*y
        2      5       1         4      3          6
  
  2     2-10   25     251       2514    25143     251436 

  5     X       5-10   51        514    5143      51436

  1     X       X     1-20        14     143       1436

  4     X       X      X          4-12    43       436 

  3     X       X      X           X      3-72      36

  6     X       X      X          X         X      6-24

  2 ko phodne ki cost = 1*2*5(x*ball*y) = 10  
  5143 ko phodne ki cost in 251436  if ham 5 ko last me phodte h toh left me kuch nhi and right me 143 vs 1f ham 1 last me ko phodte toh left me 5 and right me 43 ki cost add kr do and if ham 4 ko phodte h to left me 51 phoota h and 3 already phoota h toh cost will be c(51) + c(3) +2*4*6(bcz ye toh phoot hi nhi rhe kabhi)

  index bursting ->  2  [5  1  4   3]  6
                    i-1  i         j   j+1
                    let us consider 5 phoot rha h we can see dp mat as 143 is at i+rk so 5143 ka index i+rk-1 hoga
*/ 



class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int g = 0;g < dp[0].length;g++){
            for(int i = 0,j = g;j < dp[0].length;i++,j++){
                for(int lk = g + 1,rk = 1;lk >= 1;lk--,rk++){
                    int left = (lk == g + 1 ? 0:dp[i][j-lk]);//i same j change hoga -> movement on row
                    int right = (rk == g + 1 ? 0:dp[i+rk][j]);//j same i change hoga -> movement on col
                    
                    int val = (i - 1 >= 0 ? nums[i - 1] : 1) * nums[i + rk - 1] * (j + 1 < nums.length ? nums[j + 1] : 1);                  //i-1            //burst ballone                           //j+1
                    
                    dp[i][j] = Math.max(dp[i][j],left + right + val);
                }
            }
        }
        return dp[0][dp[0].length - 1];
    }
}