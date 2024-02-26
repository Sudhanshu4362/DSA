// https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/

/*

1,3/hh 22/hv 
 \    /       \/
1,2/h      2,1/v
  h\    /v
    1,1

1,1 se 2 option a horizontal or vertical for h we reach on 1,2 with h in answer and so on..
if we go out of maze return from there and in last cell print path so far.

*/

class Solution {
    public static void printMp(int sr,int sc,int dr,int dc,int psf){
        if(sr > dr || sc > dc){
            return;
        }
        if(sr == dr && sc == dc){
            System.out.println(path);
            return;
        }

        printMp(sr,sc + 1,dr,dc,psf + "h");
        printMp(sr + 1,sc,dr,dc,psf + "v");
    }
}