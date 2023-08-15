// catalan Number based
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-brackets-official/ojquestion /

//given a number n, representing the number of opening brackets and closing brackets
//find the number of ways in which you can arrange the brackets if closing bracketsnever exceed opening brackets

/*Approach:


for n = 1 => ()  -> b1 =1=c1
for n = 2 => ()(),(()) -> b2 = 2 => (0)1 b0b1 + (1)(0) b1b0 => 2 ,0-no brackets,1-brackets,for (0)1 -> no brackets
inside brackets both are outside brackets
for n=3-()()(),()(()),(())(),(()()),((())) -> (0)2->()(()) ,()()()  -2
                                              (1)1 -> (())()        -1
                                              (2)0 -> ((())) , (()())-2
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