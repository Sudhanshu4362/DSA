// link : https://leetcode.com/problems/sort-array-by-parity/
// move all evens at start followed by odd

/*
two pointers i & j at 0 if odd found move i++ if even found swap i & j and move both i & j
collect even behinds j
i i i
7 5 6 2 3 9 4 11 8
j
i i i i
6 5 7 2 3 9 4 11 8
j j
i i i i i i i
6 2 7 5 3 9 4 11 8
j j j
i i i i i i i i i
6 2 4 5 3 9 7 11 8
j j j j
6 2 4 8 3 9 7 11 5
*/

// code:
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        
        while(i < nums.length) {
            if(nums[i] % 2 == 1) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return nums;
    }
}
