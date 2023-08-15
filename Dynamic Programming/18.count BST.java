// https://leetcode.com/problems/unique-binary-search-trees/ 

// Given an integer n, return the number of structurally unique BST's which has exactly n nodes of 
// unique values from 1 to n

/* Approach:
1.for 0 only one bst possible-default
2.for 1 one bst -a
3. for 2 two bst's -> a->b,b->a
4.for 3 5 bst's possible.
formula-> f(0) X f(2) + f(1) X f(1) + f(2) X f(0)
            1.2 + 1.1 +1.2 = 5
*/
//based on catalan number

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0]  = 1;//n=0
        dp[1] = 1;//n=1
        
        for(int i = 2;i <= n;i++) {
            int left = 0;
            int right = i - 1;
            while(left <= i - 1) {
                dp[i] += dp[left] * dp[right];// add all combinations
                left++;
                right--;
            }
        }
        return dp[n];
    }
}