// https://practice.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
// https://leetcode.com/problems/count-number-of-ways-to-place-houses/
// N length road given have houses on both sides -> constructct such that no two buildings come together on one side

/* Approach:
1.if we consider only one side then it is same problem as count problem
2.for both side square the total buildings 

     0   1    2       3          
  B  0   B    SB      BSB,SSB 
  S  0   S    BS,SS   SBS,BSS,SSS
*/

class Solution {
    int MOD = 1000000007;
    public int countHousePlacements(int n) {
        long zero = 1;
        long one = 1;
        
        for(int i = 2; i <= n; i++){
            long nz = one;
            long no = (zero + one) % MOD;
            
            one = no;
            zero = nz;
        }
        
        long tot = (one + zero) % MOD;
        long ans = (tot * tot) % MOD;
        return (int)ans;
    }
}