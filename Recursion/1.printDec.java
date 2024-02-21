//  Link -> https://www.geeksforgeeks.org/program-to-print-numbers-from-n-to-1-in-reverse-order/

// PrintDec(4) => 4,3,2,1 

/*Approach
HLT:
1.faith -> assume pd(3) will give 321 as output
2.set expectation -> pd(4) -> 4321
3.met expectation with faith -> pd(4) -> 4.pd(3).
*/

// code : 

class GFG{
 
// Recursive function to print 
// from N to 1
  static void PrintReverseOrder(int N)
  {
     
    // If N is less than 1 then 
    // return static void function
    if (N == 0)
    {
        //LLT -> do not print zero -> kha rukna h
        return;
    }
        System.out.print(N + " ");
 
        // Recursive call of the function
        PrintReverseOrder(N - 1);
   }
}