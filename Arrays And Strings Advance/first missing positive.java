// link -> https://leetcode.com/problems/first-missing-positive/

/* Approach ->
Approach 1 -> if extra space is allowed
1.maintain a boolean array of same size if 1 to size + 1 is present put true else false in arr 
2. for 4 put true at third index
3. first false at 6 i.e 7 is not in array i.e idx + 1
nums ->    4 -5 12 2 -6 6 43 1 1 20 10 1 9 3 47 5 8
boolarr->  1 1 1 1 1 1 0 1 1 1 1  1  0  0  0  0
           0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

Approach2 -> in same array
1.in first traverse select all negatives and not in range i.e greater then size and replace it with size + 1
2.again loop in array create negative i.e for 4 make third index -ve and for 17 do nothing as 16 idx is not present
3.parse gain on array and return first positive i.e 6 + 1

    4  -5    12  2 -6    6  43  11  20   10  1   9  3 47 5 8
1-> 4  17   12   2 17    6  17  11  17   10  1   9  3 17 5 8
2-> -4 -17  -12  -2 -17  -6  17 -11 -17 -10  -1 -9  3 17 5 8

*/

// code
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] <= 0 || nums[i] > n){
                //if not in range then replace it
                nums[i] = n + 1;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            //we have to take absolute value bcz we may have changed it bcz of previous index
            int val = Math.abs(nums[i]);
            
            if(val <= n){
                //if value is in range i.e less than size then find index and make -ve
                int idx = val - 1;
                //make only negative only if +ve is present
                if(nums[idx] > 0){
                    nums[idx] = -1 * nums[idx];
                }
            }
        }
        
        
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0) {
                return i + 1;
            }
        } 
        //if all present return 17 i.e size + 1
        return n + 1;
    }
}