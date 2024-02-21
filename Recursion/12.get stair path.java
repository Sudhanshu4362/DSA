// problem link => https://www.geeksforgeeks.org/problems/count-ways-to-nth-stairorder-does-not-matter5639/1

//rules :  1,2,3 steps are only allowed in one ay up

/* Approach:-


       
        0
     /  |    \
    3   2    1   
    1\  2|  3/
         4


4 se 1 step leke 3 ,2 step leke 2 and 3 step leke 1 pe ja skte h
3 se [111,12x,21,3x] => so finally from 4 =>[1111,112,121,13] raste h
2 se [11,2X] => 4 se [211,22X]
1 se [1] => 4 se [31]

*/
// code
public class Solution {
	public static ArrayList<String> gsp(int n) {
		// Write your code here.
        if(n == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        } else if(n < 0){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }

        ArrayList<String> pfnm1 = gsp(n-1);
        ArrayList<String> pfnm2 = gsp(n-2);
        ArrayList<String> pfnm3 = gsp(n-3);

        ArrayList<String> pfn = new ArrayList<>();

        for(String path : pfnm1){
            String pathfn = "1" + path;
            pfn.add(pathfn);
        }
        for(String path : pfnm2){
            String pathfn = "2" + path;
            pfn.add(pathfn);
        }
        for(String path : pfnm3){
            String pathfn = "3" + path;
            pfn.add(pathfn);
        }

        return pfn;
	}
}