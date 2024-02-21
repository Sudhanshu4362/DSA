// Problem Link -> https://www.codingninjas.com/studio/problems/subsequences-of-string_985087

/* gss(abc) => x x x ->
               x x c -> c
               x b c -> b
               a x x -> bc
               a x c -> a
               a b x -> ac
               a b c -> abc
*/

/* Approach :-
1.Exp => gss(abc) = [ , c ,b,bc,a,ac,ab,abc]
faith => gss(bc) = [,c,b,bc]
EWF =>   gss(abc) => X.gss(bc) + a.gss(bc)

               X  =>[" "] => kuch nhi ka khali ss
               |
               c => [" ",c] => kuch nhi akela and kuch nhi with c
               |
              b c => [" ",c   => c ke ss and c ke ss ke aage b
                       b_ bc]
               |
             a b c => [,c,b,,bc,a,ac,ab,abc] => bc ke ss and bc ke ss ke aage a

*/

// code :
class Solution {
    public static ArrayList<String> gss(String str) {
        // Write your code here
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            String thess = "";
            bres.add(thess);
            return bres;
        } 

        char ch = str.charAt(0); //first character
        String ros = str.substring(1); //res of string
        ArrayList<String> rres = gss(ros);
        ArrayList<String> myRes = new ArrayList<>();
        //subsequences without character we have removed
        for(String rstr : rres){
            myRes.add(rstr);
        }
        //ubsequences with character we have removed
        for(String rstr : rres){
            myRes.add(ch + rstr);
        }

        return myRes;
    }
}