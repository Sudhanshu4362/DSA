// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article 

// given a sequence of matrix find the most efficient way to multiply those matrix together ,the efficient way is that involve least number of multiplications

/* Approach:

 1. create a 2D dp Matrix
 2. Traverse on matrix diagonly i.e (g = 0 -> g = 1 -> g = 2)
 3. for g = 0 -> all singular matrix -> ans = 0
 4. for g = 1 -> like AB ko generate krne me ops => arr[i] * arr[j] * arr[j+1] as only one way to multiply 2 mat.
 5. for g > 1 -> k1 at 1 and k2 at g and loop till k1 <= g at calculate left,right,multc
    left = same row i.e same i and change colms(j-k2) we are moving from j-g to j in left i.e row as k2.
    right = same col i.e same j and i + k1 -> as for each next ops our i is increasing by 1 and to gap so basically add k1
    multc = i.(j+1).(i+k1) 
 6. take min of min vs left + right + multc

 if input is given like : A-2  -> A - 2 X 3
                          B-3     B - 3 X 4
                          C-4     C - 4 X 5 
                            5

        ways to multilply ABC->
          ABC    (bc)  AB     ABC > bnane me operations
        2.3.5   3.5.4 2.4.3  2.5.4
             \ /         \  /
        (90)A(BC)   (AB)C(64) -> operations
                 \  /
                 ABC
     ABC ko multiply krne ke 2 tarike h first is A into whole BC and AB into C 
     A(BC) -> BC banane me 3.5.4 operations and ABC bnane me 2.3.5 => total 90 operations
     (AB)C -> AB bnane me 2.4.3 operations and ABC bnane me 3.5.4 operations => total 64 operatons
 
   op1 mo1 op2 o1 mo o2 o1 mo op2
    \  |  /    \  | /   \  | /
    A(BCD)   (AB)(CD) (ABC)D
           \  \      /
            A  B   C D
            op -> number of operations required to get that multiplication
            mo -> number of operations in multiplication of both
              10    20      30    40   50
              A     B        C     D  
     10 A     A-0   AB-6k    ABC   ABCD    (i,j) 
     20 B     X     B-0      BC-24k BCD    (i+1,j)
     30 C     X      X      C -0    CD-60k (i+2,j)
     40 D     X      X       X      D-0    (i+3,j)
     50      (i,j-3) (i,j-2) (i,j-1) (i,j)
      3 steps :
          1: Store
          2: Move
          3: Calculate
        we will store in matrix -> the number of ops req to generate that matrix 
        at g = 0 all singular matrix -> no multiplication reqired -> so ans = 0
        at g = 1 , 2 matrix multiply karne ka ek hi tarika h 10x20 vs 20x30 => ops = 10.30.20 i.e i.j.j+1
        at g > 1 ->  ABC ko bahrne ko 2 tarike h A(BC) and (AB)C as we have discussed so same row ka pehla(i.e A) and col ka next(BC) total ops = A + BC + ABC and for next variation row++,col++ i.e AB and C ko leke take min of all                     op1 + op2 + mo
        mo for ABC => 10x20 vs 20x30 => 10x30 vs 30x40 => 10x40=> total ops => 10.40.30(i,j+1,i+k1)
*/

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp = new int[arr.length - 1][arr.length - 1];
        
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                //diagonal end at last col so move j from g to dp[0].length
                if(g == 0){
                    dp[i][j] = 0;
                } else if(g == 1){
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else {
                   // 
                   int min = Integer.MAX_VALUE;
                   for(int k1 = 1, k2 = g; k1 <= g; k1++, k2--){
                       int left = dp[i][j - k2]; //dimensions -> arr[i] * arr[j - k2 + 1] -> movement on row -> left ->right move
                       int right = dp[i + k1][j]; // arr[i + k1] * arr[ j + 1] -> movement on col ->downward motion 
                       int multc = arr[i] * arr[j + 1] * arr[i + k1];
                       
                       min = Math.min(min, left + right + multc);
                   }
                   dp[i][j] = min;
                }
            }
        }
        
        
        return dp[0][dp[0].length - 1];
    }
}