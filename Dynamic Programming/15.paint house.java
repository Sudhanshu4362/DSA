// https://www.codingninjas.com/studio/problems/paint-house_1460385
/* you are given n houses and 3 colors and cost of painting of each house with given colors return min cost to paint
house s.t no two consecutive houses have same color*/

/* Approach :
1.difine r,g,b with first three value i.e cost of painting house upto one with red,green,blue
2.for second and beyond houses if we are calculating price of paint of house with red then we take min of other two
3.calculate newred,new green,new blue paints cost for all houses and update r,g,b for each and return min of three  


4    r g b    
 H1  1 5 7      
 H2  5 8 4   -> 
 H3  3 2 9     
 H4  1 2 4     
         1      2         3       4
  R      1     5+5 = 10   3+5=8   1+7=8  --> min -> ans
  G      5     8+1 = 9    2+5=7   2+8=10
  B      7     4+1 = 5    9+9=18  4+7=11

  for n = 1 add as it is 
  for n = 2 as we cant paint two same consc.colors so take min of other two and add to it
*/

public class Solution {
    public static int minCost(int[][] arr) {
        int r = arr[0][0];
        int g = arr[0][1];
        int b = arr[0][2];
        for(int i = 1; i < arr.length; i++){
            int nr = arr[i][0] + Math.min(g, b);
            int ng = arr[i][1] + Math.min(r, b);
            int nb = arr[i][2] + Math.min(r, g);
            r = nr;
            g = ng;
            b = nb;
        }
        
        int ans = Math.min(r, Math.min(g, b));
        return ans;
    }   
}