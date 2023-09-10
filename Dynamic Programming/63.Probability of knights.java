// https://practice.geeksforgeeks.org/problems/probability-of-knight5529/1 
// NXN chessboard, knight at (x,y). The knight has to take exactly k steps,where at each step he chosses any of 8 directions uniformly at random. What is the probability that that knight remains in the chessboard after taking k steps.


/* Approach:
 Intuition : Travel in board, update to that box where knight can move after kth move and return the sum of all probabilities.
 Approach:
 1.Maintain a 3D array of dp. and at dp[row][col][0] = 1.
 2.make a direction array
 3.traverse all steps  and traverse the matrix
 4.get x = i + dir[0] and y as j + dir[1] and check if it is in matrix then add its probability
 5.In the end again loop the array and add all probablities.


 0  0  0  0  1st step    0   0   0  1/8   2nd step   0   0   0   0
 0  1  0  0  =========>  0   0   0   0    ========>  0 2/64  0   0
 0  0  0  0              0   0   0  1/8              0  0   1/64 0
 0  0  0  0              1/8 0  1/8  0               0 1/64  0   0

 1st move me board me sabhi 8 position pe jake uski probability 1/8 kar denge 
*/

class Solution
{
    public double findProb(int N, int row, int col, int k)
    {
        // Code here
        double[][][] dp = new double[N][N][k+1];
        dp[row][col][0] = 1;
        
        int[][] dirs = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
        for(int move = 1;move <= k;move++){
            for(int i = 0;i < dp.length;i++){
                for(int j = 0;j < dp[0].length;j++){
                    for(int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x >= 0 && x < N && y >= 0 && y < N){
                            dp[x][y][move] += dp[i][j][move - 1]/8;
                        }
                    }
                }
            }
        }
        //probability of complete board.
        double res = 0;
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < dp[0].length;j++){
                res += dp[i][j][k];
            }
        }
        return res;
    }
}