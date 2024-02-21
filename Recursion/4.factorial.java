// Link -> https://www.geeksforgeeks.org/problems/factorial5739/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//fct(5) -> 5.4.3.2.1

/* Approach:
Expectation -> f(5) =5 X 4 x 3 X 2 X 1
faith -> f(4) -> 4 X 3 X 2 X 1
EWF -> 5 X f(4)

*/

// code :
class Solution{
    static long factorial(int N){
        
        if(N == 0){
            return 1;
        }
        // code here
        long fnm1 = factorial(N-1);
        long fn = N * fnm1;
        
        return fn;
    }
}