
//you will be given 2D array of 1's and 0's 1 -> means obstacle and o means you can go
//all direction moves allowed t,l,d,r
/
/* Approach:
   
 0   1   0   0    0   0   0
 0   1   0   1    1   1   0
 0   0   0   0    0   0   0
 1   0   1   1    0   1   1
 1   0   1   1    0   1   1
 1   0   0   0    0   0   0

 0,0 -> first call t ki laggegi but we will be out of maze so we have to return and second call will be l and again out of maze so third call will be of down which will be allowed and so on for all the cells 4 call lgegi.
 viited array for mark that cell that is visited nhi toh vhi fase rhege but wapas jate hue mark removes krne honge to explore other paths also. => backtracking
 */

class Solution {
    public static void floodFill(int[][] maze,int row,int col,String psf,boolean[][] visited) {
        if(row < 0|| col < 0 || row == maze.length || col == maze[0].length || maze[[row][col] == 1 || visited[row][col] == true]){
            return;
        }

        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;
        floodfill(maze,row-1,col,psf + "t",visited);//top call
        floodfill(maze,row,col-1,psf + "l",visited);//left
        floodfill(maze,row+1,col,psf + "d",visited);//right
        floodfill(maze,row,col + 1,psf + "r",visited);//right

        visited[row][col] = false;
    }
}