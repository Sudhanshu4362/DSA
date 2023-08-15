// BASED ON CATALAN NUMBER
// in how many ways you can present x and y such that y never crosses x's a any point

//no of upstrokes never crosses downstrokes => y never crosses x -> same as valley and mountain
// for e.g n = 2 2X and 2Y => 2 ways [XX,XY] 

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