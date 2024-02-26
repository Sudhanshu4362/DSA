//recursion on the way up
//https://www.geeksforgeeks.org/print-subsequences-string/
//why recursion on the way up
/* from gss ques -> abc => ["",c,b,bc,a,ac,ab,abc]
                    3 -> 2^3 items => 2^3/2 pairs => 2^2 pairs => 2^2.3 character = 12
                    n => 2^n-1.n characters
                    .n becz har pair me n items hote h

                    for n = 31 => 2^30 .31 = (2^10)^3.31 = 1024^3.31 =>31.10^9 bytes => 31gb storage will be needed

so print the subsequence generated and so on .

      abc  ab.   
       \  /   \/    \/   \/
        c/ab  c/a   c/b  c/.
           \  /       \ /
            bc/a      bc/.
              t\      f/
                 a b  c

*/

// code:

class Solution{
    public static void printSS(String s,String ans) {

        if(s.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);

        printSS(ros,ans + ch);
        printSS(ros,ans + "");
    }
}