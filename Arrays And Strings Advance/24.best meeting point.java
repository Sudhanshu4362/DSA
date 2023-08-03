// link -> https://www.codingninjas.com/studio/problems/best-meeting-point_1463982
// 1-> rep home,0->no home
// minimize verticle and horizontal distance

/*
1. To minimize distance we can meet them on median
1,2,4,5,6,8 -> cols that have 1's -> median 4th col
0,1,2,3,4,5 -> rows that have 1's -> median 2nd row so (4,2) is meeting point
2.maintain two arraylist xcord and ycord
3.xcord me vo x add kr do jha 1 ho and ycord me vo y add kr do jha 1 ho
4.calculate x,y median by xcord.size/2
5.calculate distance to travel by subtracting it with median of both x,y

   0 1 2 3 4 5 6 7 8 <-col
0  0 1 0 0 0 1 0 0 0
1  0 0 1 0 0 0 0 0 0
2  0 0 0 0 0 0 1 0 0
3  0 0 0 0 0 0 0 0 1
4  0 0 0 0 1 0 0 0 0
5  0 0 1 0 0 0 0 0 0
^
row

*/
// code
public class Main {
    public static int minTotalDistance(int[][] grid) {
        ArrayList<Integer> xcord = new ArrayList<>();
        ArrayList<Integer> ycord = new ArrayList<>();
        // for row coordinates
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    xcord.add(r);
                }
            }
        }
        // for col coordinates
        for(int c = 0; c < grid[0].length; c++) {
            for(int r = 0; r < grid.length; r++) {
                if(grid[r][c] == 1) {
                    ycord.add(c);
                }
            }
        }

        int x = xcord.get(xcord.size() / 2);
        int y = ycord.get(ycord.size() / 2);
        
        // calculate distance
        int dist = 0;
        for(int i = 0; i < xcord.size(); i++) {
            dist += Math.abs(xcord.get(i) - x) + Math.abs(ycord.get(i) - y);
        }
        return dist;
    }
}
