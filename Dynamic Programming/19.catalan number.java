// https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1 

// catalanNumber -> is a sequence of numbers.
//c0 = 1,c1 = 1,c2 = c0c1+c1c0 = 2,c3 = c0c2+c1c1+c2c0 = 5,c4 = c0c3+c1c2+c2c1+c3c0 =14
//c0*c(n-1) -> to find catalan number

/* Approach:
1.define dp[0] and dp[1] as c0 and c1
2.loop from i =2 to n and a left and right for each catalan
3.left at 0 and and right at i-1 and loop while left <= i-1
4.and calculate dp[i] as dp[left] * dp[right] + dp[i] and left++,right--
*/

class Solution {
    public static int findCatalan(int n) {
        int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			int left = 0;
			int right = i - 1;
			while(left <= i - 1) {
				dp[i] += dp[left] * dp[right];
				left++;
				right--;
			}
		}
		return dp[n];
    }
}
