// Link -> https://leetcode.com/problems/longest-happy-prefix/
// Simple LPS problem -> return the longest happy prefix of s

//we dont have to check for each character we have to find it for whole string

/* Approach:
1.create lps array
2.find lps of last character
3.return s.sustring(0,k);
*/

class Solution {
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        
        while(i < lps.length) {
            if(s.charAt(i) == s.charAt(len)) {
                lps[i] = len + 1;
                len++;
                i++;
            } else if(len == 0) {
                lps[i] = 0;
                len = 0;
                i++;
            } else {
                len = lps[len - 1];
            }
        }

        int k = lps[s.length() - 1];
        return s.substring(0,k);
    }
}