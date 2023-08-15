// BASED ON CATALAN NUMBER.
//given a maze you can move horizontally and vertically in one move find no of ways from bottom left to top right
// such that you do not move below diagonal

/* Approach:
if you rotate the matrix you can obeserve its same problem as valley and mountain  -> /\/\/\/\/\/\....

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