// Link -> https://practice.geeksforgeeks.org/problems/search-pattern0205/1

// a string will be given to you you will be given a pattern you have to search it in string
// print the indexes of all the occurences of pattern string in the text string. 

/*
Brute force -> O(m * n) -> acquire and release 
KMP -> O(m + n)
KMP:
1.create LPS-it stores length of logest prefix jo suffix bhi ho
2.initial length is zero len = 0
3.loop on string and check if string at char at i is equal to the str.charAt(len) it means previous are all same 
inc the length if next character also matches else if len is zero then lps[i] me zero krdo and length ko zero
and check next character and if character mismatches len ko update krdo to lps[len -1].
4.get lps for pattern string
5.now loop on string txt and i at 0 of txt and j at patrn end check if character at i == j increment both i and j
if j reaches end of pattern  then add it to your ans and j ko lps[j-1] if j == 0 then inc i only
6. if j is not at 0 then we have to do same as we do lps i.e jo ko lps[j-1] 



abcd -> prefix - a,ab,abc,abcd & suffix - d,cd,bcd,abcd
proper prefix-a,ab,abc and prop. suffix - d,cd,bcd

txt -> a a b a a c a a b a a d a a b a a c a a b a  a  e ,  pat -> aab
lps -> 0 1 0 1 2 0 1 2 3 4 5 0 1 2 3 4 5 6 7 8 9 10 11 0

else case for lps -> for aabaa and aabaa are same and len =5 but now c and d are not same so we check for lpsof
len - 1 which is 2 i.e c se pehle a h jiska lps 2 h ,now len =2 and aa are same with aa now check is for b and d 
which is again not same again len = lps[len-1] which is 1 ,now a and a matches we check a and d which again
mismatches len is now lps of a which is 0 so d ka bhi zer0
         i i i i i i            
   txt-> a a b a a c a a b a a d a a b a a c a a b a  a  e  

         j j j j j j    
   pat - a a b a a
         0 1 0 1 2

i at c and j at end now check lps of prev. that is a-2 so move j to 2nd index and check if it equals with c
which is not so again move j to lps[j-1] i.e at 1 ,a is not equal to c ,again do it till j reaches zero
  aabaa    
  a          a 
  aa         aa -> longest prefix jo suffix bhi h
  aab        baa
  aaba       abaa     
*/

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int[] lps = getLPS(pat);
        
        int i = 0;
        int j = 0;
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                
                if(j == pat.length()){
                    res.add(i - j + 1);
                    j = lps[j - 1];
                }
            } else if (j == 0){
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        
        
        return res;
    }
    
    int[] getLPS(String pat){
        int[] lps = new int[pat.length()];
        
        int len = 0;
        int i = 1;
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                // i and char at len matches ,continue previous
                lps[i] = len + 1;
                len++;
                i++;
            } else if(len == 0){
                // pichle character ke liye bhi same nhi h and current bhi same nhi h
                lps[i] = 0;
                len = 0;
                i++;
            } else {
                //length is not zero ,previous characters matches but char at i and len doesn't matches set len to
                // lps[len -1]
                //aabaac, aabaad -> d and c mismatches,len =2 ,aab,aad-> b,d mismatch->len= 1,aa and ad,a d mismatch len->0
                len = lps[len - 1];
            }
        }
        
        return lps;
    }
}