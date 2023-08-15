// https://www.lintcode.com/problem/516/ 
// no of color is variable -> return min cost to paint houses

/* Approach:
 1. for house 1 we have only one choice if we paint with that color or not ->add prices as it is
 2. for house 2 and beyond price will be apna + min but for min we will add smin with that for e.g min =1and smin=2
 all rows we add min bt min wale column me smin add kro so that no two house have same color.

                          1      2         3        4         5        6

2 5 1 3 2 3               2      5+1=6     1+3=4    3+4=7     2+6=8    3+9=12
5 8 1 6 7 4               7      8+1=9     1+3=4    6+4=10    7+6=13   4+8=12
7 2 3 4 5 6               5      2+1=3     3+6=9    4+4=8     5+6=11   8+8=16
1 9 7 6 3 8               1      9+2=11    7+3=10   6+4=10    3+6=9    8+1=9
2 5 9 2 4 7               2      5+1=6     9+3=12   2+4=6     4+7=11   7+8=15
 */

public class Solution {
    public int minCostII(int[][] arr) {
         int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(int j = 0; j < arr[0].length; j++){
            if(arr[0][j] <= min){
                smin = min;
                min = arr[0][j];
            } else if(arr[0][j] <= smin){
                smin = arr[0][j];
            }
        }

        for (int i = 1; i < arr.length; i++) {
            int cmin = Integer.MAX_VALUE;
            int csmin = Integer.MAX_VALUE;

            for(int j = 0; j < arr[i].length; j++){
                if(arr[i - 1][j] != min){
                    arr[i][j] += min;
                } else {
                    arr[i][j] += smin;
                }

                if(arr[i][j] <= cmin){
                    csmin = cmin;
                    cmin = arr[i][j];
                } else if(arr[i][j] <= csmin){
                    csmin = arr[i][j];
                }
            }

            min = cmin;
            smin = csmin;
        }
        return min;
    }
}