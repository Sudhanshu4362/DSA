// link -> https://leetcode.com/problems/maximum-product-subarray/

/* Approach :
1st method: prefix and suffix se
1.calculate prifix and suffix prodts
2.first loop 1 -> length and if zero product then prdct of 1 kro and if apna product res se bda h to update kro
3.similarly loop for suffix len to 1 calculate product and update on greater result if prd = 0 then 1 kr do
  prod
a <-> b -> all possible ans
- * + * - -> a.prod.b
- * + * + -> prod.b
+ * + * - -> a.prod
+ * + * + -> a.prod.b
- * - * - -> a.prod or prod.b
- * - * + -> a.prod or b
+ * - * - -> a or prod.b
+ * - * + -> a or b
                                                60<--------------
                                     16<-------      12<--------
                                         2<---           3<-- <-sufx
arr->     2   3   -5   0   -6   -1   8   2   0   5   4   3
prfx->  -->2             --->-6                -->5 
        ------->6        -------->6            ------->20
        ------------>-30 ------------->48      ------------->60
                         ------------------>96
*/

// code
class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int prd = 1;
        for(int i = 0;i < nums.length;i++) {
            prd = prd * nums[i];
            if(prd > res) {
                res = prd;
            }
            if(prd == 0){
                prd = 1;
            }
        }
        prd = 1;
        for(int i = nums.length - 1;i >= 0;i--) {
            prd = prd * nums[i];
            if(prd > res) {
                res = prd;
            }
            if(prd == 0) {
                prd = 1;
            }
        }
        return res;
    }
}

/* Method -2 kadane's algo
1.take max and min 
2.if number is positive our max will be max * nume[i] or sirf num[i] and min will be min of(min * num[i],num[i])
3.but if number is negative max will be max of(min * num[i],num[i]) and min will be min of(prev max * num[i],num[i])
4.in last result will be max of all the maxs
*/

// code:
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= 0){
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            } else {
                int temp = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(temp * nums[i], nums[i]);
            }
            
            res = Math.max(res, max);
        }
        
        return res;
    }
}