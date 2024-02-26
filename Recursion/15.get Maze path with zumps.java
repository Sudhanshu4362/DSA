// https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
//diagonal traversal also allowed


/*
s -> d jane ke raste => e1p1,e1,p2....,e2p3,..e3p5..           
                d
          ///  |||  \\\
          i1   i2   i3
          e1\ e2| e3/
                s

HORIZONTAL MOVES => 

*/

class Solution {
    public static ArrayList<String> getMazePathsZ(int sr,int sc,int dr,int dc){

        if(sr > dr && sc > dc){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        } else if(sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add(" ");
            return bres;
        }

        ArrayList<String> myPaths = new ArrayList<>();
        //Horizontal moves
        for(int hm = 1;hm <= dc-sc;hm++){
            ArrayList<String> myhPaths = getMazePaths(sr,sc + hm,dr,dc);
            for(String hpath : myhPaths){
                myPaths.add("h" + hm +hpath)
            }
        }

        //vertical moves
        for(int vm = 1;vm <= dr-sr;vm++){
            ArrayList<String> myvPaths = getMazePaths(sr + vm,sc,dr,dc);
            for(String vpath : myvPaths){
                myPaths.add("v" + vm +myvPath)
            }
        }
        // diagonal
        for(int ds = 1;ds <= dr-sr && ds <= dc-sc;ds++){
            ArrayList<String> mydPaths = getMazePaths(sr + ds,sc + ds,dr,dc);
            for(String dpath : mydPaths){
                myPaths.add("d" + ds +mydPath)
            }
        }
        return myPaths;
    }
}

