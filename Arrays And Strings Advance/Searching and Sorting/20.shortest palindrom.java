// Link -> https://leetcode.com/problems/shortest-palindrome/description/

//given a string you can convert a string to a pallindrome by adding some characters in front of it
//Return the shortest palindrome you can find by performing this transformation.

/*
intitution -> 
1.Find longest prefix which is pallindrome 
2.after that reverse all characters and add it into front of given string
*/

/* Approach:
1.take string given add a new special chrcter to it andagain add reverse of string -> nitinabc&cbanitin
2.find Lps of it
3.get len of longest pallindromic length as lps[lps.len-1]
4.we need substring of string after that index -> we will get string after pallindrome reverse it  and add it to str
5.


 str -> n i t i n a b c
 nitin is longest prefix plaindrome ,abc is not so reverse it and add it into front -> cbanitinabc

 str- > n i t i n a b c & c b a n i t i n
 lps -> 0 0 0 0 1 0 0 0 0 0 0 0 1 2 3 4 5
*/

class Solution {

  public String shortestPalindrome(String str) {
    String s1 = str + "$" + new StringBuilder(str).reverse().toString();//nitinabc&cbanitin

    int[] lps = new int[s1.length()];
    int len = 0;
    int i = 1;
    while (i < lps.length) {
      if (s1.charAt(i) == s1.charAt(len)) {
        lps[i] = len + 1;
        len++;
        i++;
      } else if (len > 0) {
        len = lps[len - 1];
      } else {
        lps[i] = 0;
        len = 0;
        i++;
      }
    }

    int ppl = lps[lps.length - 1];//it will give length of lengest string
    String right = str.substring(ppl);//get abc from nitinabc
    return new StringBuilder(right).reverse().toString() + str;
  }
}
