//reference get Maze path
// https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/

/*


    


  h1\ h2| /v1...///
    1 , 1

    */

   class Solution {
    public static void printMazePathsZ(int sr,int sc,int dr,int dc,int psf){
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return bres;
        }
        //Horizontal moves
        for(int hm = 1;hm <= dc-sc;hm++){
            printMazePathsZ(sr,sc + hm,dr,dc,psf + "h" + hm);
        }

        //vertical moves
        for(int vm = 1;vm <= dr-sr;vm++){
            printMazePathsZ(sr + vm,sc,dr,dc,psf + "v" + vm);
        }
        // diagonal
        for(int ds = 1;ds <= dr-sr && ds <= dc-sc;ds++){
           printMazePathsZ(sr + ds,sc + ds,dr,dc,psf + "d" + ds);
        }
    }
}
