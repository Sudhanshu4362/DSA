// Link -> https://leetcode.com/problems/majority-element-ii/

// find all elements that appear more the n/3 times
//there can be atmost two elements in array whose appearence is more then n/3 time
/* Approach:
1.Intialize candiate 1 and candidate 2 for majority elemenent and there count cnt1,cnt2 to zero
2.Loop on array and if both candidates are present check it with can1 and can2 and inc the count of matched candidate
in case of no match decrease the freq of both
3. if only can1 is present check it matches can1 then inc its counter else set this value to can2 and inc cnt2 else
if case for same if can2 is present only do the same
4.again loop on array and get count of can1 and can2
5.if it is greater then n/3 add it to result list
      i i i i i i i i i i i i i i
arr-> a b a a b b c d e a b a b c
can1-> a->a        cnt1-1->2->3->2->1->0->1->2->1
can2-> b->b        cnt2-1->2->3->2->1->0->1->2->1
loop and check if a,b appeared more then n/3 times

first no majority so add a to can1 now b does not matches a so add it to can2
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int can1 = 0;
        int cnt1 = 0;
        int can2 = 0;
        int cnt2 = 0;
        
        for(int val: nums){
            if(cnt1 > 0 && cnt2 > 0) {
                // if both are present then check to which it matches and inc thats count
                if(val == can1) {
                    cnt1++;
                } else if(val == can2) {
                    cnt2++;
                }else {
                    //kisi se match nhi
                    cnt1--;
                    cnt2--;
                }
            } else if(cnt1 > 0) {
                //if only first candidate is present
                if(val == can1) {
                    //value same to can1 -> inc cnt1
                    cnt1++;
                } else {
                    // value not same so define can2 and inc cn2
                    can2 = val;
                    cnt2++;
                }
            } else if(cnt2 > 0) {
                // if only can2 is present
                if(val == can2) {
                    cnt2++;
                } else {
                    can1 = val;
                    cnt1++;
                }
            } else {
                //if ek bhi majority nhi h toh can1 ke equal krke count bdha do
                can1 = val;
                cnt1++;
            }
        }
        // again loop on array and get count of can1 and can2
        cnt1 = 0;
        cnt2 = 0;
        for(int val: nums){
            if(val == can1){
                cnt1++;
            } else if(val == can2){
                cnt2++;
            }
        }
        //verify if it is > n/3 or not and add to result list
        ArrayList<Integer> res = new ArrayList<>();
        if(cnt1 > nums.length / 3){
            res.add(can1);
        }
        if(cnt2 > nums.length / 3){
            res.add(can2);
        }
        
        return res;
    }
}