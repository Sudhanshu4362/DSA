// link:https://leetcode.com/problems/largest-number-at-least-twice-of-others/
// det wheather the largest number is atleast twice of every element otherwise return -1

/* Approach:
1. find first and second largest element in the array 
2. check if twice of second largest is less then largest or not

why -> we dont have to check for each element because if second largest is less then all elements will be less
3 6 1 0
s.l = 3
l = 6
condition satisfy return true
*/
// code1
class Solution {
    public int dominantIndex(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;
        
        for(int i = 0;i < nums.length;i++){
            if(idx1 == -1 || nums[i] >= nums[idx1]){
                idx2 = idx1;
                idx1 = i;
            } else if(idx2 == -1 || nums[i] >= nums[idx2]) {
                idx2 = i;
            }
        }
        if(nums[idx1] >= 2 * nums[idx2]) {
            return idx1;
        } else {
            return -1;
        }
    }
}

// code2
class Solution {
    public int dominantIndex(int[] nums) {
        int[] temp = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int l = temp[temp.length-1];
        int sl = temp[temp.length - 2];

        if(l >= 2 * sl){
            for(int i = 0;i < nums.length;i++){
                if(nums[i] == l){
                    return i;
                }
            }
        }
        return-1;
    }
}