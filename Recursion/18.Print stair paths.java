// https://www.geeksforgeeks.org/print-all-ways-to-reach-the-nth-stair-with-the-jump-of-1-or-2-units-at-a-time/

/* Approach : 

 \|/  \|/  \|/ 
2/11 1/12 ./13     
   \   | /   \|/    \|/
      3/1    2/2   1/3
         1\   2|  3/
              4

0 pe journey khthm ho jati h so print on zero but return on negativ

*/

// code

class Solution {
    public static void printSP(int n,int path){
        if(n < 0){
            return;
        }
        if(n == 0){
            System.out.println(path);
            return;
        }

        printSP(n-1,path + "1");
        printSP(n-1,path + "2");
        printSP(n-3,path + "3");
    }
}