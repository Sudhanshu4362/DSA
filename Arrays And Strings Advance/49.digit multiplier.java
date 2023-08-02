// https://practice.geeksforgeeks.org/problems/digit-multiplier3000/1
// find the smallest number S such that the product of all the digits of S is equal to the number N.

/* Approach :
1.diide with greater number so that we get min digits 
2. i.e first divide with 9 -> 8 -> 7 ---1
3.if it completely divide number add it to string and return reverse of it

100 - 9-8-7-6-5
20 - 9---5
4 - 9--5-4
554 -> 455 ans

26 -> 9----2
13 -> invalid 13 whole is not a digit
*/

class Solution {
    static String getSmallest(Long N) {
        // code here
        StringBuilder sb = new StringBuilder();
        if(N < 10){
            // less then 10 wale me whi number return 4 -> 4,6->6
            return N + "";
        }
        //divide from 9 to 1
        for(int div = 9; div > 1; div--){
            while(N % div == 0){
                N = N / div;
                sb.append(div);
            }
        }
        
        if(N >= 10){
            //10 ke beyond factor is not valid
            return "-1";
        }    
        return sb.reverse().toString();
    }
};