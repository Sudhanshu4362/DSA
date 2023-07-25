// link : https://leetcode.com/problems/reverse-vowels-of-a-string/
// reverse vowels present in given string

/* Approach :
maintain a string check conatianing all the vowels and left at 0 and right at end
while left is not a vowel move left++ and while right is not a vowel move right--
if both are vowel swap the vowels by using sb.setCharAt(li,sb.charat(ri))
l l
l e e t c o d e
              r
l l l              
l e e t c o d e
          r r r
l l l l l
l e o t c e d e
        r r r r
*/

// code:
class Solution {
    public String reverseVowels(String s) {
        String check = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder(s);
        int li = 0;
        int ri = sb.length() - 1;
        while(li < ri) {
              while(li < ri && check.indexOf(sb.charAt(li)) == -1){
                li++;
            }
            
            while(li < ri && check.indexOf(sb.charAt(ri)) == -1){
                ri--;
            }
            char temp = sb.charAt(li);
            sb.setCharAt(li,sb.charAt(ri));
            sb.setCharAt(ri,temp);
            li++;
            ri--;
        }
        return sb.toString();
    }
}