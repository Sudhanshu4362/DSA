// Link -> https://takeuforward.org/data-structure/print-n-to-1-and-1-to-n-using-recursion/

// pdi(4) = 43211234

/*Approach ->
1.Expectation -> pdi(4) => 43211234
2.faith -> pdi(3) -> 321123
3.EWF -> 4.pdi(3).4
*/
//code:
public class Solution{
    public static void pdi(int n) {
      if (n == 0) return;

      System.out.print(n + " "); //pre area
      pdi(n - 1);                //recursive call
      System.out.print(n + " "); //post area
    }
}
