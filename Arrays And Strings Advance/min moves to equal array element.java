// link -> https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

/*
Approach :
instead of inc n-1 element by 1 we can dec 1 element by 1
find min and make all element equal to min i.e total me num[i] -min steps legege min ke equal lane me so add this 
to res

1 2 3
min = 1
c = 1-1 + 2-1 + 3-1 = 3 moves
*/

// code
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = Math.min(min,num);
        }
        int res = 0;
        for(int num : nums) {
            res += num - min;
        }
        return res;
    }
}