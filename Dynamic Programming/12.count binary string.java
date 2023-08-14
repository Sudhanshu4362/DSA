// https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
/* count no of binary string with no consecutive 0's. */

/* Approach:
1.initialize zero and ones with 1.(for n = 1)
2.loop from 2 to n and calculate newZeros and newOnes.
3.newZeros will be ones in prev.as they were obtained by appending zeros to them as they are ending with one so no
two zeros comes together.
4.newOnes will besum of zero + ones as consecutive 2 ones are allowed
 n = 5 [binary strings]
for n = 0 count of zero and one will be 0
for n = 1 cont of one and zero both are 1
for n = 2 count of zero will be count of 1 for n = 1 and count of ones will be sum of both one and zero
       0     1      2        3          
  0 -> 0     0 |1   10 | 1  010,110|2
  1 -> 0     1 |1   01 | 2  101,011|3
                    11 |     111
*/
class Solution {
    int countStrings(int n) {
        int zero = 1;
        int one = 1;
        for(int i = 2; i <= n; i++){
            int nzero = one;
            int none = zero + one;
        
            one = none;
            zero = nzero;
        }
        return (one+zero);
    }
}
// code for gfg -> CONSECUTIVES ONES NOT ALLOEWED INSTEAD OF ZERO
class Solution {
    int countStrings(int n) {
        int MOD = 1000000007;
        int zero = 1;
        int one = 1;
        for(int i = 2; i <= n; i++){
            int nzero = (one + zero) % MOD;
            int none =  one % MOD;
        
            one = none;
            zero = nzero;
        }
        return (one+zero) % MOD;
    }
}