// https://leetcode.com/problems/distinct-subsequences-ii/ 
// given a string return the number of distinct non-empty subsequences of s

// Input: s = "abc"
// Output: 7
// Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".

/* Approach:
1.Maintain a Dp array.
2.dp[0] = 1,dp[1] = 2
3.dp[i] will be 2 * dp[i-1] and minus duplicates will depend wheather it is repeated or not
4.Maintain a array to store last ocurrences and add first character at 1th location of dp bcz string ka 0 = dp ka 1
5.now get character and check if it is present in last occurrence array if yes minus dp of last occurrence ch se 1 piche se  from dp[i] i.e dp[i] - dp[lo[ch] -1]

str ->  X   a    b    c     a     b     c
count-> 1   2    4    8     15    28    52
ss ->   .   a    ab   []c
            .    .b   []
                 a.
                 ..
 X ka 1 subseq is blank
 a ke 2 subseq a,.
 b ke 4 subseq i.e a and . ke sath blank aa gya and second option is nhi aaya so 2 * ds(a) i.e 2 * dp[i-1]
 c ke 8 similary as b
 now for a 16 total no of subsequences and we have to minus pichle wale a ke piche ka subseq i.e X -> 16-1=15
 same for c total 56 - b ke subseq i.e 56-4= 52 bcz last time jab b aaya tha toh 4 ke sath c nhi add hua tha so they will repeat at this c.
*/

class Solution {
    int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 2;
        int[] lo = new int[26]; //last occurence
        lo[s.charAt(0) - 'a'] = 1; //first ch in dp ki 1 pe tha
        for(int i = 2;i < dp.length;i++) {
            dp[i] = (2 * dp[i-1]) % MOD;
            int ch = s.charAt(i-1) - 'a';
            if(lo[ch] != 0){
                //if it is present in last occurences
                dp[i] = (dp[i] - dp[lo[ch] -1] + MOD)%MOD;
            }
            lo[ch] = i;
        }
        return (dp[s.length()] - 1 + MOD) % MOD;
    }
}