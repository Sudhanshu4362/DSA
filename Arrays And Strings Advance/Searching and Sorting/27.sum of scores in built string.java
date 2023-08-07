// Link -> https://leetcode.com/problems/sum-of-scores-of-built-strings/

/* You are building a string s of length n one character at a time, 
prepending each new character to the front of the string. 
The strings are labeled from 1 to n, where the string with length i is labeled si. 
The score of si is the length of the longest common prefix between si and sn
Given the final string s, return the sum of the score of every si.

abaca -> a->ca->aca->baca->abaca -> how string is made by appending char in front
score of a is longest common prefix b/w a and str
score of ca is longest common prefix b/w ca and str -> this is z value-> c start hone wali subse badi string
*/

/* Approach :
1.create z-array
2.score is sum of z values of all the elements

*/

class Solution {
    public long sumScores(String s) {
        long ans = s.length();
        
        int[] z = new int[s.length()];
        int l = 0;
        int r = 0;
        for(int i = 1; i < z.length; i++){
            if(i > r){
               l = r = i;
                while(r < z.length && s.charAt(r) == s.charAt(r - l)){
                    r++;
                }
                
                r--;
                z[i] = r - l + 1;
            } else {
                int k = i - l;
                if(z[k] < r - i + 1){
                    z[i] = z[k];
                } else {
                    l = i;
                    while(r < z.length && s.charAt(r) == s.charAt(r - l)){
                        r++;
                    }

                    r--;
                    z[i] = r - l + 1; 
                }
            }
        }
        
        for(int val: z){
            ans += val;
        }
        
        return ans;
    }
}