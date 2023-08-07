// link -> https://www.codechef.com/problems/SECPASS

// fiind all those prefix which lies in string
//return  prefix which frequency in string is most for same frequency return longest
/* Approach:
1.get z array of string
2.create hashmap of I,I to store freq of all prefix , we assumed prefix as a-1,aa-2,aab-3
3.initialize ans and freq
4.loop on map and if current freq is greater then freq replace ans to that key in map and freq to curr freq
5.if freq same then if key > ans replace our ans to that key
6.return substring from 0 to that ans i.e for a->0,1,aa->0-2,aab->0-3
          i
        0 1 2 3 4 5 6 7 8 9 10  11
str ->  a a b c a a b x a a a   z
z-ar -> 0 1 0 0 3 1 0 0 2 2 1   0
str[1] ki z array represent a ki ek occurance now increase count of a to
str[4] ki z array represens aab ki 1 ,aa ki 1 and a ki one occurence we alerady have ocurrance of a is 1+1=2
str[5] -> a->2+1
str[8] -> a->3+1=4 and aa to 1+1 =2
str[9] -> a->4+1 =5 and aa to2+1 =3
str[10]-> a->6
inki real freq. are + 1 as we have stored - 1 to all
prefis:
a -> 6
aa ->2
aab ->1
aabc =0
aabca =0
aabcaa =0
aabcaab =0
aabcaabx= 
aabcaabxa
aabcaabxaa
aabcaabxaaa
aabcaabxaaaz = 0

*/
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scn = new Scanner(System.in);
	    int t = Integer.parseInt(scn.nextLine());
	    
	    while(t-- > 0){
	        int len = Integer.parseInt(scn.nextLine());
	        String s = scn.nextLine();
	        String ans = solve(s);
	        System.out.println(ans);
	    }
	}
	
	public static String solve(String s){
	    int[] Z = getZArray(s);
        //fmap -> a-1,aa-2,aab-3 and unke samne frequencies
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for(int val: Z){
	        if(val == 0){
	            continue;
	        }
	        for(int v = 1; v <= val; v++){
	            map.put(v, map.getOrDefault(v, 0) + 1);
	        }
	    }
	      
        int ans = 0;
        int freq = 0;
        //find string with largest freq.
        for(int key: map.keySet()){
            if(map.get(key) > freq){
                // if curr frq is greater then our assumed freq.
                freq = map.get(key);
                ans = key;
            } else if(map.get(key) == freq){
                //in case of equal freq. get largest
                if(key > ans){
                    ans = key;
                }
            }
        }

        if(ans == 0){
            return s;
        }
        //return substrin s to key as we have stored in integer form
        return s.substring(0, ans);
	}
	
	public static int[] getZArray(String s){
	    int[] Z = new int[s.length()];
	    
	    Z[0] = 0;
	    
	    int l = 0;
	    int r = 0;
	    for(int i = 1; i < s.length(); i++){
	        if(i > r){
	            l = r = i;
	            while(r < s.length() && s.charAt(r) == s.charAt(r - l)){
	                r++;
	            }
	            
	            r--;
	            Z[i] = r - l + 1;
	        } else {
	            int k = i - l;
	            if(Z[k] < r - i + 1){
	                Z[i] = Z[k];
	            } else {
	                l = i;
    	            while(r < s.length() && s.charAt(r) == s.charAt(r - l)){
    	                r++;
    	            }
    	            
    	            r--;
    	            Z[i] = r - l + 1;
	            }
	        }
	    }
	    
	    return Z;
	}
}