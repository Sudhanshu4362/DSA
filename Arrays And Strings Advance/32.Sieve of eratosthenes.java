// link ->
// Given an integer n, return the number of prime numbers that are strictly less than n.

/* Approach:
1.n + 1 size ka boolean array
2.0,1 are not prime
3.2 ki table uthayi and sare false kr diye
4.3 ki table 3 se chala ke sare false kr diye
5.4 ki chalane ki jrurat nhi bcz vo already false h 2 ki vjah se and 4 ke sare false honge
6.5 ki table chalayege 5 * 5 se and so on
7.table sirf root n tak chalani hoti h
0 1 2  3  4 5 6 
7 8 9  10
*/
// code :
class Solution {
    public int countPrimes(int n) {
        if(n < 2) {
            return 0;
        }
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes,true);
        
        primes[0] = false;
        primes[1] = false;
        
        for(int tbl = 2;tbl*tbl <= n;tbl++){
            if(primes[tbl] == false) {
                continue;
            }
            for(int ja = tbl;tbl * ja <=n;ja++) {
                primes[tbl * ja] = false;
            }
        }
        int count = 0;
        for(int i = 0;i < primes.length - 1;i++) {
            if(primes[i] == true) {
                count++;
            }
        }
        return count;
    }
}