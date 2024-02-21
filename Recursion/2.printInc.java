// Link -> https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops3621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//pi(5) -> 1,2,3,4,5

/*Approach:
1.faith -> pi(4) -> 1,2,3,4
2.expectation -> pi(5) -> 1,2,3,4,5
3.EWF -> pi(5) -> pi(4).5

*/
// code
class Solution{
    static void printTillN(int N){
        // code here
        if(N == 0){
            return;
        }

        printTillN(N-1);
        System.out.println(N + " ");
    }
}
