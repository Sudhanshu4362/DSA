// link -> https://leetcode.com/problems/majority-element/description/
// number appering more than n/2 times

/* approach
 brute force -> frequency map
 optimal -> moores voting algorithm
 start traversing on array from start with variable me which is eqal to first element and create a count variable 
 if nums[i] == me then count++ else count-- if count == 0 then there is no me till that i and me == nums[i]
 | | | | | | | | | | |
 7 7 2 7 4 6 5 7 7 7 8 -
 me = 7->5->7
 c = 1->2->1->2->1->0->1->0->1->2->3->2 
*/

// code
class Solution {
    public int majorityElement(int[] nums) {
        Integer me = null;
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(count == 0){
                me = nums[i];
                count = 1;
            } else if(nums[i] == me){
                count++;
            } else {
                count--;
            }
        }
        return me;
    }
}