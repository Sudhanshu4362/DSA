//  link -> https://leetcode.com/problems/maximum-product-of-three-numbers/
// find 3 no's in array whoose product is maximum

/* Approach :
1.loop on array and get three largest(max1,max2,max3) numbers and min1 and min2
2.if all positive then answer will be product of all 3 max values and if -ve value is also present then 
min1*min2*max1
*/

class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        
        for(int num : nums) {
            if(num <= min1) {
                min2 = min1;
                min1 = num;
            } else if(num <= min2) {
                min2 = num;
            }
            
            if(num >= max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if( num >= max2) {
                max3 = max2;
                max2 = num;
            } else if(num >= max3){
                max3 = num;
            }
        }
        return Math.max(min1 * min2 * max1,max3 * max2 * max1);
    }
}