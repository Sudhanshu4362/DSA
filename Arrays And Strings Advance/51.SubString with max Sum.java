// Link -> https://leetcode.com/problems/find-the-substring-with-maximum-cost/

/*
*/

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = s.length();
        int[] cost = new int[n];
        char[] ch = s.toCharArray();

        for(int i = 0;i < n;i++){
            int idx = chars.indexOf(ch[i]);

            if(idx == -1) {
                cost[i] = (ch[i] - 'a') + 1;
            } else {
                cost[i] = vals[idx];
            }
        }
        int currSum = 0;
        int maxSum = 0;
        for(int i = 0;i < n;i++){
            if(currSum < 0){
                currSum = cost[i];
            } else {
                currSum += cost[i];
            } 
            maxSum = Math.max(maxSum,currSum);                                  
        }
        return maxSum;
    }
}