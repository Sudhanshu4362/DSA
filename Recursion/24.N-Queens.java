//you are given a number n the size of chess and you have to place n queen such that no queens kills another 
// queens kills in all 8 direction and any number of steps

/* Approach:
for a 4X4 board there are only two possible ways such that no queens kills other

   0  1   2   3
0     *   #  
1 #           *
2 *           #
3     #   * 

* => 01,13,20,32
# => 02,10,23,31

hint => 1 row and col. me 1 hi queens and kisi row ko skip nhi kr skte

   
        r1
            c0\ c1|  c2/
        r0        .
*/

class Solution{
    public static void printNQueens(int[][] chess,String qsf,int row){
        if(row == chess.length){
            System.out.println(qsf + ".");
            return;
        }
        //NodePre 
        for(int col =  0;col<chess.length;col++){
            if(isSafeforQueen(chess,row,col)){
                chess[row][col] = 1;
                //edgePre
                printNQueens(chess,qsf + row + "-" + col +"," , row + 1);
                //edgePost
                chess[row][col] = 0;
            }
        }
        //nodePost
    }
    public static boolean isSafeforQueen(int[][] chess,int row,int col){
        for(int i = row - 1,j = col;i >= 0;i--){
            if(chess[i][j] = 1){
                //vertically me khi bhi koi aur queen ho toh
                return false;
            }
        }
        for(int i = row - 1;j = col -1;i >= 0,j >= 0;i--,j--){
            if(chess[i][j] = 1){
                //main diagonal (\)me khi bhi koi aur queen ho toh
                return false;
            }
        }
         for(int i = row - 1;j = col +1;i >= 0,j < chess.length;i--,j++){
            if(chess[i][j] = 1){
                //other(/) diagonal me khi bhi koi aur queen ho toh
                return false;
            }
        }
        return true;
    }
}