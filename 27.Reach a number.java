// Link -> https://leetcode.com/problems/reach-a-number/
// find the number of jumps to rach target in number line from 0
//ith move i size ka h 
/* Approach->
1.caculate range by x*(x-1)/2
2.if target is in range and type of target and range of same type i.e for odd target range should be odd
3.if candition satisfy so break and return x jumps

0->8-: 0->-1->1->4->8
step -> dest
n -> -n(n+1)/2 -> n(n+1)/2
1 -> -1,1
2 -> -3,3 -> 2.3/2 = 3 -> only odds visited(-3,-1,1,3)
3 -> -6,6 -> 3.4/2 = 6 -> only evens visited(-6,-4,-2,0,2,4,6)
4 -> -10,10-> 4.5/2 -> for 8 it comes in range so 4 steps will be required
*/

// code
class Solution {
    public int reachNumber(int target) {
        int x = 0;
        target = Math.abs(target);
        
        while(true) {
            int range = x * (x + 1) /2;
            if(range >= target && range % 2 == target % 2) {
                break;
            }
            x++;
        }
        return x;
    }
}