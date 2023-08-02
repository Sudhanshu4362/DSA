// Link -> https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

/*Given an array of integers nums and an integer threshold, we will choose a positive integer divisor
Divide all the array by it, and sum the division's result. 
Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
*/

/*
Approach :
1.lo at 1 and hi at constraint i.e 10000000
2.calculate mid 
3.us mid ko divsor man ke calculate sum of quotients for each element in array
4.if sum > threshold -> mid is smaller i.e ans is b/w mid + 1 to hi so lo= mid +1
5.if sum < threshold -> mid is greater i.e ans is b/w mid to lo so hi= mid

To decrease the sum we increase the divider
 arr ->  1  2  5  9  th = 6
div-1 =  1+2+5+9 = 17 > 6
div-2 =  1+1+3+5 = 10 >6
div-3 = 1+1+2+3 =  7>6
div-4= 1+1+2 +3 =  7>6
div-5 = 1+1+1+2 = 6 = 6

const - divisor 10 ki power 6 se bda nhi hoga isko hi set kr dege
mid nikal ke sum nikalege agar ye threshold se badi aata h toh mid chota le liya bada number lena tha toh 
mid + 1 to hi me hamra answer h else me mid bda le liya h mid se lo tak dekhege
max se bde and min se chote se divide nhi kr skte -> no effect
*/

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int hi = 1000000;
        while(lo < hi){
            int mid = (lo + hi)/2;
            int sum = 0;
            for(int val : nums){
                //mid se divide krke calculating quo and taking sum
                int quo = (val + mid -1) / mid;
                sum += quo;
            }
            if(sum > threshold){
                //sum bda h i.e divsor chota h
                lo = mid + 1;
            } else {
                //sum kam h i.e divisor bda h
                hi = mid;
            }
        }
        return lo;
    }
}