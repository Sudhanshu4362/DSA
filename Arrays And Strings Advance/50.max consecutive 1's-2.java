// Link -> https://www.lintcode.com/problem/883/
 // find the maximum number of consecutive 1s in this array if you can flip at most one 0.

 /* Approach :
 1.we can flip 0 zeros i.e we can max acquire 3 zeros in a sequence
2.release if count of zeros exceeds 1 so release zeros till become valid
 */

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j = 0;
        int countz = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countz++;
            }

            // if zeroes are more make j move and remove 0's to make it valid
            while(j < i && countz > 1){
                if(nums[j] == 0){
                    countz--;
                }
                
                j++;
            }

            int len = i - j + 1;
            res = Math.max(res, len);
        }

        return res;
    }
}