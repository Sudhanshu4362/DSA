// https://leetcode.com/problems/ugly-number/ 
// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

// Input: n = 6
// Output: true
// Explanation: 6 = 2 × 3

// Input: n = 14
// Output: false
// Explanation: 14 is not ugly since it includes the prime factor 7.

/* Approach:
1.maintain a divisors array having 2,3,5
2.now loop on divisors array and while n % div == 0 divide the number.
3.return  if n == 1.

for e.g 300/2 = 150/2 = 75/3 = 25/5 = 5/5 = 1
*/

class Solution {
    public boolean isUgly(int n) {
        if(n == 0){
            return false;
        }
        int[] divs  = {2,3,5};
        for(int div : divs) {
            while(n % div == 0){
                n = n/div;
            }
        }
        return n == 1;
    }
}