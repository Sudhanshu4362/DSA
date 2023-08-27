// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/ 
//catalan + mcm
// you have n sided polygon with each vertex has an value given as values[i] in clockwise order 
//your task is to triangulate the polygon into n-2 triangles. for each triangle the value of that triangle is product of the values of its vertex and total cost of triangulation is sum oa all of these n-2 triangles.
// return the smallest total possible cost of triangulation

/* Approach:
if polygon has n sides then we can trianguluate it to catalan of n-2(done previously)

      a      b      c       d        e          f

  a   a-0   ab-0  abc-abc   abcd     abcde     abcdef

  b   X      b-0    bc-0    bcd-bcd   bcde       bcdef  

  c   X       X      c-0     cd-0     cde-cde     cdef

  d   X       X      X        d-0      de-0       def      

  e   X       X      X        X         e-0       ef-0    
 
  f   X        X     X        X          X         f-0

  for g = 0 and g = 1 we cant triangulate them so answer will be 0 as a point and line cant be triangle
  for abc ko 1 hi tarika h so ans will be abc
  for abcdef -> if we make abf traingle then left me ab + right me bcdef or for acf -> left me abc and right me def
  or adf ka triangle left side me abcd and right me def or def ka triangle left-abcde and right side-ef and add cost of each triangles to get cost of triangulation
*/
class Solution {
    public int minScoreTriangulation(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        
        for(int g = 0;g < dp[0].length;g++) {
            for(int i = 0,j = g;j < dp[0].length;i++,j++){
                if(g == 0 || g== 1){
                    dp[i][j] = 0;
                }  else {
                    dp[i][j] = Integer.MAX_VALUE;
                    
                    for(int lk = g - 1,rk = 1;lk >= 1;lk--,rk++){
                        int left = dp[i][j - lk];
                        int right = dp[i + rk][j];
                        int val = arr[i] * arr[i + rk] * arr[j];
                        dp[i][j] = Math.min(dp[i][j],left + right + val);
                    }
                }
            }
        }
        return dp[0][dp[0].length - 1];
    }
}