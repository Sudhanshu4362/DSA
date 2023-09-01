// https://leetcode.com/problems/ugly-number-ii/ 

// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return the nth ugly number.

// Input: n = 10
// Output: 12
// Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

/* Approach:
Intuition -> first generate a ugly number then by using that number generate next ugly number.
Approach:
1.3 pointer for 2,3,5.
2.loop on dp and multiply by 2,3,5 by their respective in dp to generate next ugly number
3.take min 
4.and inc. the pointer whose value we are taking


 [1] * 2 / [1] * 3 / [1] * 5 -> to generate next possible ugly number. take min as next ugly number and next possible ugly number will be generated from 3,5

            2,3,5
 dp[] -> [X  1     2     3     4     5     6    8    9    10]
                  2,3,5  2,3
 dp[1] will be 1 (base case)
 for 2nd ugly number multibly 1 by 2,3,5 -> 2 is min so move pointer 2 to 2 and rest at 1
 for 3rd ugly number multibly 1 by 3,5 -> 3 is min so move pointer 3 to 2 and 5 at remains 1
 for 4th ugly number multibly 1*5 gives 5,2*2 = 4 and 3*2 gives 6 -> 4 is min so move pointer 2 to 3
*/

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2=1;//2 pointer
        int p3=1;//3 pointer
        int p5=1;//5 pointer

        for(int i = 2;i < dp.length;i++){
            int f2 = dp[p2] * 2;
            int f3 = dp[p3] * 3;
            int f5 = dp[p5] * 5;

            dp[i] = Math.min(f2,Math.min(f3,f5));
            if(dp[i] == f2){
                p2++;
            } 
            if(dp[i] == f3){
                p3++;
            }
            if(dp[i] == f5){
                p5++;
            }
        }
        return dp[n];
    }
}