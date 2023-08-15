// https://www.geeksforgeeks.org/count-ways-divide-circle-using-n-non-intersecting-chords/
// given a number n ,find no of ways that you can draw n chords from 2n points such that no two chords intersect.

/* Approach:
for n = 2 -> only one chord can be created
for n = 4 -> 2 ways -> 1,2 or 1 or 4 points ko jod ke chord bna skte h -> c0c1 + c1c0 =2
for n = 6 -> 5 ways 
 so we can draw chords to the half of catalan number i.e for n = 6 we take catalan of 3
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
		return dp[n] / 2;
    }
}