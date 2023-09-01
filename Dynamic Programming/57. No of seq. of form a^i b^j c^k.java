// https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1 

// Given a string S, the task is to count number of subsequences of the form aibjck 

// Input: S = "abbc"
// Output: 3
// Explanation: Subsequences are abc, abc and abbc.

/* Approach:


str ->  a     b      c      a'      b'     c'
 
a+      1(a)  1(a)   1(a)   3       3      3
a+b+     0    1(ab)  1(ab)  1(ab)   5      5 
a+b+c+   0    0      1(abc) 1(abc) 1(abc)  7 

for every a a+ will impacted,for b a+b+ will be impact,for every c a+b+c+ will be impacted.
c aane per -> 2c + b bcz abc wala as it is + abc ke piche c' lg jaye so twice of c + ab walo ke piche c'
b aane per -> 2b + a bcz-> picle wala dobara + unke piche b' so twice b ans jo pichle a+ wale h unke piche b' so +a
a aane per -> 2a + 1 bcz-> pichle wale as it aa skte h and unke piche a' lag skta h so twice  + 1 for sirf a' aa jaye
*/

class Solution
{
    public int fun(String s)
    {
        int ca = 0;
        int cab = 0;
        int int cabc = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                ca = 2 * ca + 1;
            } else if(ch == 'b'){
                cab = 2*cab + ca;
            } else if(ch == 'c'){
                cabc = 2*cabc + cab;
            }
        }
        return cabc;
    }
}