// Link->https://leetcode.com/problems/consecutive-numbers-sum/description/
// Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.

/* Approach->
1.insitialize k = 1 for ek number and calculate check a k(k-1)/2
2.loop while check < n and n-check/k h to ek ans mil gya i.e 1 starting point and k mil gya
3.re calculate check for each k
t(n) = root(n)


n}-> s +.......+knumbers
1-> s + 0
2-> s + 1

k -> s + (k-1)
+_______________
sum = ks + k(k-1)/2 = n
ks = n- k(k-1)/2

1. n - (k-1)k/2 > 0 => k(k-1)/2 < n as ks > 0
2. (n- k(k-1)/2)/k == 0 should for natural number and for existence of s

n = 15
k = 1 -> 1(0)/2 = 0 < 15,n - k(k-1)/2/k => 15-0%1 ==0->starting is 15 -> 15 se start hkr 1 hi number milega jo 15 h
k = 2 -> 2(1)/2 = 1 < 15,15-1%2 == 0=> 7 se start hoker 2 number h [7,8]
k = 3 -> 3(2)/ = 3 < 15, 12/3 == 4 => 4 se start hokr 3 number h[4,5,6]
k = 4 -> 4(3)/2 =6 <15,9%2 != 0 6 se start hokr koi number nhi h
k = 5 -> 5(4)/2 =10<15,5%2 != 0 10 se bhi nhi hoga
*/

//code
class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int k = 1;
        int check = k * (k - 1)/2;
        while(check < n) {
            if((n - check) % k == 0) {
                res++;
            }
            k++;
            //re calculating check for next k
            check = k * (k - 1)/2;
        }
        return res;
    }
}