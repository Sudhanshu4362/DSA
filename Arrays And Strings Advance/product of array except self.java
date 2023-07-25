// link -> https://leetcode.com/problems/product-of-array-except-self/
// return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

/* Approach : 
maintain leftarr and right for left[i] = left[i-1] * left[i-1]
take right =1 and calculate right = right * nums[i + 1]
final output will be left[i] = left[i] * right

arr -> a     b      c     d        e       f 
left-> 1     a     ab    abc      abcd     abcde
right->bcdef cdef  def    ef       f        1
o/p -> bcdef  scdef abdef  abcef  abcdf    abcdef -> left * right
*/

// code
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1;i < nums.length;i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 2;i >= 0;i--) {
            right = right * nums[i + 1];
            left[i] = left[i] * right;
        }
        return left;
    }
}