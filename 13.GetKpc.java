// problem link :https://www.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1

/* 
 6    7
 p    t
 q    u   => pt,pu,qt,qu,rt,ru,st,su => these are possible combinations by pressing 6 and 7 key.
 r
 s

 Exp => kpc(67) =>  pt,pu,qt,qu,rt,ru,st,su
 faith => kpc(7) => t,u
 Ewf => p.kpc(7)
        q.kpc(7)
        r.kpc(7)
        s.kpc(7)

             X
             |
             7
             |
            6 7
*/

// code : 

class solution{
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> kpc(String str) {

        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            String thess = "";
            bres.add(thess);
            return bres;
        } 

        char ch = str.charAt(0);//6
        String ros = str.substring(1); //7
        ArrayList<String> rres = kpc(ros);
        ArrayList<String> myres = new ArrayList<>();

        int ii = ch- 48; // string to integer
        String code = codes[ii];

        for(int i = 0; i < code.length(); i++){
            char chcode = code.charAt(i);
            for(rrstr : rres){
                myres.add(chcode + rstr);
            }
        }
        return myres;
    }
}