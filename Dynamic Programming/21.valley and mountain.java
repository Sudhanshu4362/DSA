//
//given upstrokes and downstrokes, find no of valleys and mountains you can create using strokes

/* Approach:
SAME AS CATALAN NUMBER.

 VM0-> 1 -> --
 VM1-> 1 -> /\
 VM2-> 2 -> /0\1 + /1\0 =>2 [/\/\,//\\]
 VM3 -> 5 -> /0\2 + /1\1 + /2\0 => 5 [/\/\/\,/\//\\,//\\/\,//\/\\,///\\\]
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