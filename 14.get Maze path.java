// https://www.codingninjas.com/studio/problems/paths-in-a-maze_981287

// you are at top of maze(0,0) you have to move to last cell and right and down moves are allowed \
// for e.g (0,0) -> (2,2) => [hhvv,hvhv,hvvh,vhhv,vhvh,vvhh]

/* Apprroach:

          
          2,2
      /       \
     0,1     1,0
       h\   v/ 
         0, 0

0,1 se jo bhi raste h usme h add krdo and 1,0 se jo bhi raste h vha v add kr do
0,1 => vvh,vhv,hvv =>hvvh,hvhv,hhvv
1,0 => vvhh,vhvh,vhhv

*/
// code

class Solution {
    public static ArrayList<String> getMazePaths(int sr,int sc,int dr,int dc){

        if(sr > dr && sc > dc){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        } else if(sr == dr && sc == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add(" ");
            return bres;
        }
        ArrayList<String> myPaths = new ArrayList<>();
        ArrayList<String> myhPaths = getMazePaths(sr,sc + 1,dr,dc);
        ArrayList<String> myvPaths = getMazePaths(sr + 1,sc,dr,dc);

        for(String myhpath : myhPaths){
            myPaths.add("h" + myhpath);
        }
        for(String myvpath : myvPaths){
            myPaths.add("v" + myvpath);
        }

        return myPaths;
    }
}
