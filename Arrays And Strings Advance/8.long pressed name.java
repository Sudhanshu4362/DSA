// link - > https://leetcode.com/problems/long-pressed-name/

/* approach: 
two pointer i & j at typed and name and start traversing on typed if tped[i] = name[j] move both i & j
if not same then check for name[i-1] if true move i++ if not same with i or i - 1 then return false
        i i i i i i i                   i i i i i i
typed : a a l e e x x                   s s a a e d d
name:   a   l  e  x                     s   a   e e d  -> return false
        j   j  j  j return true         j   j   j j
*/

// code:
class Solution {
    public boolean isLongPressedName(String n, String t) {
        int i = 0;
        int j = 0;
        while(i < t.length()) {
            if(j < n.length() && t.charAt(i) == n.charAt(j)){
                i++;
                j++;
            } else if(i > 0 && t.charAt(i) == t.charAt(i - 1)){
                i++;
            } else {
                return false; // ssaaedd saeed
            }
        }
        
        return j == n.length(); // aalexx alexa
    }
}