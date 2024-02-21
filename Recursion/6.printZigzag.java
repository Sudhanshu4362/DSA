//for input 1 -> outpuy will be 111
//for 2 -> 2 111 2 111 2
// for 3 -> 3 2 111 2 111 2 3 2 111 2 111 2 3
//          3[ 2 ka o/p]   + 3 +[2 ka o/p] 3

/*
1.Expectation -> pzz(3) => 3 2 111 2 111 2 3 2 111 2 111 2 3
2.faith -> 2 111 2 111 2
3.EWF => 3.pzz(2).3.pzz(2).3
         n.pzz(n-1).n.pzz(n-1).n


  0  0  0  0  0  0  0  0
   \/    \/    \/    \/
    1    1      1    1
     \  /        \  / 
       2          2
         \      /
             3

*/

// code :

class Solution{
    static long pzz(int n){
        
        if(n == 0){
            return 1;
        }
        // code here
    System.out.println(n);//pre area
    pzz(n-1);//call
    System.out.println(n);//mid area
    pzz(n-1);//call
    System.out.println(n);//post area
    }
}