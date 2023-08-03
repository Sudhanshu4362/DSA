// link -> https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

/*given an integer array nums where the ith bag contains nums[i] balls and maxoperations
operations -> 1.Take any bag of balls and divide it into two new bags with a positive number of balls.
              2.a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

*/

/* Approach:
1.get lams as 1
2.hams as max of all elements
3.calculate mid as ams
4.operations  req   to check how many operation needed according to this ams (mid)
5.loop on array and check if currball is > ams if yes we need operations
6.if count of operations max ops se jyada h means jyada chota bag rkh liya so inc allowed max size by going into
right side else go to left side


nums = [2,4,8,2], maxOperations = 4

*/

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lams = 1; //lowest allowed max size
        int hams = 0; //highest allowed max size ->for maximum in arr we can accumulate all and no ops needed
        
        for(int num: nums){
            hams = Math.max(num, hams);
        }
        
        while(lams < hams){
            //mid -> allowed max size
            int ams = (lams + hams) / 2;
            
            int opsReqd = 0;//operation required
            for(int ball: nums){
                //if ball > allowed max size we need operations i.e for 8 and ams is 4 
                if(ball > ams){
                    int spare = ball - ams; //4
                    int ops = (spare + ams - 1) / ams; //4+4-1/4 = 2->ceil
                    opsReqd += ops;
                }
            }
            
            if(opsReqd > maxOperations){
                lams = ams + 1;
            } else {
                hams = ams;
            }
        }
        
        return lams;
    }
}