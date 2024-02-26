// https://www.geeksforgeeks.org/print-all-possible-decodings-of-a-given-digit-sequence/

//Given the numeric string str, where 1 represents ‘a’, 2 represents ‘b’, …, 26 represents ‘z’, the task is to print all possible alphabetical strings that can be obtained from str.

/* Approach : 

  X      ./abjc
  |      3|
03/aba 3/abj X    X       ./lijc
\1    /10    |    |       |3
103/ab   03/aq  03/la   3/lij
 2\     /21       1\   /10
   2103/a         103/l
        1\     12/
         1 2 1 0 3

special cases: 
1.03 is not equak to 3 so no answers from 03
   X         ./jc
    |       |3
  03/la   3/j
    1\   /10
      103
2.     
       ./iic
        |3
       3/ii
       |9
      93/i 
      9|
      993

3.
013 => X
303 >3 and 30 
     03/c  x => eventually no answer.

*/

//code :
 class Solution {
    public static void printEncodings(String str,String psf) {
        if(str.length() == 0){
            System.out.println(psf);
            return;
        } else if(str.length() == 1){
            char ch = str.charAt(0);
            if(ch == '0') {
                return;
            } else {
                int chv = ch - '0';//character to int conversion
                char code = (char)('a' + chv-1);//get code 1 -> a,2->b
                System.out.println(psf  + code);
            }
        } else {
            //call for single character
            char ch = str.charAt(0);
            String roq = str.substring(1);
            if(ch == '0') {
                return;
            } else{
                int chv = ch - '0';
                char code = (char)('a' + chv-1);
                printEncodings(roq,psf + code);
            }

            //call for 2 character
            String ch12 = str.substring(0,2);
            String roq12 = str.substring(2);

            int ch12v = ch - '0';
            if(ch12v <= 26){
                char code = (char)('a' + ch12v-1);
                 printEncodings(roq12,psf + code);
            }
        }
    }
 }
   