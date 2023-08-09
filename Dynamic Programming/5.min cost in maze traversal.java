
// you are standing at top-left cell and move to bottom right cell you are allowed to move 1 cell right ,down in
// one motion .each cell has a cost calculate min cost.
/*
1.start from bottom -> choti problem
2.last cell add as it is 
3.last row we cant go down we can only go right so from last add values of next cell to it i.e for 5->1+5=6,8->8+6
4.now else we can move right and bottom


0 1 4 2 8 2              23 23 24 20 21 19
4 3 6 5 0 4              24 22 23 18 13 17
1 2 4 1 4 6    -> dp ->  20 19 17 13 13 13
2 0 7 3 2 2              21 19 19 12 19  7
3 1 5 9 2 4              23 20 19 16  2  5
2 7 0 8 5 1              23 21 14 14  6  1
*/

public class Main {
    public static int mazeTraversal(int[][] arr){
       int m = arr.length;
	   int n = arr[0].length;
       int[][] dp = new int[m][n];
       for(int i = dp.length - 1;i >= 0;i--){
        for(int j = dp[0].length - 1;j >= 0;j--){
            if(i == dp.length - 1 && j = dp[0].length - 1){
                //for last cell
                dp[i][j] = arr[i][j];
            } else if(i == dp.length - 1){
                //for last row -> only column changes -> we can add only right
                dp[i][j] = arr[i][j] + dp[i][j+1];
            } else if(j == dp[0].length - 1){
                //for last col we can go only downwards --> only row changes
                dp[i][j] = arr[i][j] + dp[i+1][j];
            } else {
                //all moves are possible so take min of right,down
                dp[i][j] = arr[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
            }
        }
       }
       return dp[0][0];
    }
}