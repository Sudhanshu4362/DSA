// link -> https://leetcode.com/problems/range-addition/
// https://www.lintcode.com/problem/903/

/* iniialize all elements of array with zero then k set of operations like [1,3,2] i.e from index 1 to 3 add 2,
return final array after all operations. */

/* Approach :
1.get start,end update from updates array
2.add  +d and -d at start index and end + 1 index

        0   [0   0    0]     0   0   0   0 -> adding d in range[]
            +d              -d
        -----------------------------------
        0    d    d    d     0   0    0   0 -> prefix sum -> the change we wanted
        ------------------------------------

 arr -> 0   [0   {0    0]     0}   0   0   0
 d1  -> 0  +d1    0    0     -d1   0   0   0  -> adding d1[]
 d2  -> 0  +d1   +d2   0    -d1   -d2  0   0  -> adding d2{}
 ---------------------------------------
        0  +d1 d1+d2 d1+d2  d2  0  0   0 -> prefix sum
        ---------------------------------

*/
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] res = new int[length];

        for(int[] upd: updates){
            int start = upd[0];//start point
            int end = upd[1];  //end point
            int delta = upd[2]; //change in array

            res[start] += delta; //start pe add
            if(end + 1 < res.length)
                res[end + 1] -= delta;//end + 1 pe subtrct
        }

        //loop on array and prefix sum
        for(int i = 1; i < res.length; i++){
            res[i] += res[i - 1];
        }

        return res;
    }
}