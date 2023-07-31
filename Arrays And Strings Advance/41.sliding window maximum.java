// link -> https://leetcode.com/problems/sliding-window-maximum/
// return maximum in k-size window

/* Approach:
1.maintain a stack and get next greater element on right
2.push last element of array in stack and nge for last element as length[imginary]
3.loop on array from sl element till i >= 0,get value and check if val >= st.peek if yes then pop the element 
after popping all small elements  nge[i] = st.peek if st is empty i.e no next greater element
4.maintain a res array of nums.length - k +1 size
5.i at 0 and j at 0 and move j to next greater element if it is in window so make largest of that window to the j
which is largest number of that window
move i++ and again check for nge and if it is in the window so move j to that nge
6.at any point if j < i make j = i
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums.length - 1);
        nge[nums.length - 1] = nums.length;
        
        for(int i = nums.length - 2;i >= 0;i--) {
            int val = nums[i];
            while(st.size() > 0 && val >= nums[st.peek()]) {
                //pop all smaller number
                st.pop();
            }
            //all smaller popped, make nge[i] to st.peek()
            if(st.size() == 0) {
                //greater not exist
                nge[i] = nums.length;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for(int i  = 0;i < res.length;i++) {
            if(j < i) {
                j = i;
            }
            // move j if nge is in window
            while(nge[j]  <= i + k - 1) {
                j = nge[j];
            }
            //res[i] pe j store 
            res[i] = nums[j];
        }
        return res;
    }
}