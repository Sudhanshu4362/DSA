
/*



     
      
     pt   pu qt qu rt ru st su
      t\  u/ t\ u/ t\ u/ t\ u/
         67/p 67/q 67/r 67/s
           p\  q|  r/   s/
              6   7    /.

*/
//code:
class Solution{
        static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void printKpc(String ques,String ans){

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        String codeForch = codes[ch - 48];
        for(int i = 0;i < codeForch.length();i++){
            char cho = codeForch.charAt(i);
            printKpc(roq,ans + cho);
        }
    }
}