// https://www.pepcoding.com/resources/online-java-foundation/graphs/knights-tour-official/ojquestion

// 1. You are given a number n, the size of a chess board.
// 2. You are given a row and a column, as a starting point for a knight piece.
// 3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits 
//      all cells of the board exactly once.
// 4. Complete the body of printKnightsTour function - without changing signature - to calculate and 
//      print all configurations of the chess board representing the route
//      of knight through the chess board. Use sample input and output to get more idea.

/*Approach:
knight possible steps for following matrix => knight 2.5 setps move 
    0   1   2   3    4
0       *       *
1   *                *
2           X
3   *                *
4       *       * 
  i-2,j-1     i-2,j+1
  i-1,j-2     i-1,j+2
         i,j
  i+1,j-2     i+1,j+2
  i+2,j-1     i+2,j+1


make calls for all 8 possible steps and increment move by 1 for each call and unvalid calls handled by base cases

*/

class Solution{
    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
        if(r<0 || c < 0 || r >= chess.length|| c >= chess.length||chess[r][c] > 0) {
            return;
        } else if(move == chess.length * chess.length){
            chess[r][c] = move;
            displayboard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        printKnightsTour(chess,r-2,c+1,move+1);
        printKnightsTour(chess,r-1,c+2,move+1);
        printKnightsTour(chess,r+1,c+2,move+1);
        printKnightsTour(chess,r+2,c+1,move+1);
        printKnightsTour(chess,r+2,c-1,move+1);
        printKnightsTour(chess,r+1,c-2,move+1);
        printKnightsTour(chess,r-1,c-2,move+1);
        printKnightsTour(chess,r-2,c-1,move+1);
        chess[r][c] = 0;
    }
    //function to print board
     public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}