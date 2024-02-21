// problem Link : https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//given 3 tiers with disk in A you have  to print the instructions are required to moce all the disk from A -> B using C 
//rules -> one disk at a time , smaller disk should be at top

/* Approach:

for toh(3,A,B,C)
1.Expectation : toh(3,A,B,C) ->  will print all req. instructions following which we can move 3 disk from A to B using c
2.f1 -> toh(2,A,C,B) -> some instructions that will move 1,2 from A to c then 3 ko A to B(print ln)
f2 -> toh(2,C,B,A) => 12 lo B me move. 

0   0    0  0     0  0     0   0
 \  /     \/       \/        \/
  1 abc   1bca     1cab     1abc     
    \     /           \     /
      2 a c b         2 c b a
            \        /
              3 a b c
*/

//code:
class Hanoi {

    public long toh(int n, int t1, int t2, int t3) {
        // Your code here

        if(n == 1) {
            System.out.println("move disk " +n + " from rod " +t1 + " to rod " +t2);
            return 1;
        }

        toh(n-1,t1,t3,t2);
        System.out.println("move disk " +n+ " from rod " +t1+ " to rod " +t2);
        toh(n-1,t3,t2,t1);
        
        return (long)Math.pow(2,n)-1;
    }
}
