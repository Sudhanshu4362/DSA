// link -> https://practice.geeksforgeeks.org/problems/8dcd25918295847b4ced54055eae35a8501181c1/1
// z array is at any point is is the longest string starting at given point which is also its prefix.

/*
1.create new string with pattern + "$" + string
2.create z array of whole string and where z-array value is equal to pattern length here our ans present
z-algorithm ->
1.intialize z array with z[0] = 0
2.left and right at zero 
3.if left right same per h toh starting index pe check kro if same move right 1 ahead and now check st. + 1 is equl
to right or not if same bdhate rho if not same update z value of element at left with r -l + 1 and right ko ek
index back to get same string which is prefix
4.if i hamra left,right ke beech me h toh find k i.e how much i is ahead of left so go back to start and check z[k]
and if it is window i.e not beyond r-i+1 then i index pe element ka bhi z same hoge 
5.if it is not in window move l to i and increment r if next character is same as r-l wala character same as 3rd case
                                       k                        i
explanation for 4,5 case ->  [[- -] - [- -] - - -]-----[- - - - - - - -]---
                                                        l             r 
[]-> same characters
1) go back and find l-i i.e 4th index as k and check its z index let us say it is 2 it means next two element from
there will be same as from first 2 as z[4] is in window so make z[i] =2 bcz they belong to window of same elemnts
str -> a a b c a a b x a a a z
zarr-> * 1 0 0 3 1 0 0 2 3 1 0
a se strt hone wali string jo prefix bhi h is aab which is of length 3

str -> a b x a $ a a b c a a b x a a b c a find abxa in given string
zarr-> 0 0 0 1 0 1 2 0 0 1 4 0 0 1 2 
                           ^ -> our ans
        i  i
str ->  a   a   b  c   a  a b x a a b c a 
       l,r  l,r
*/

public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
        String str = p + "$" + s;
        int[] z = new int[str.length()];
        z[0] = 0;
        
        int l = 0;
        int r = 0;
        for(int i = 1; i < z.length; i++){
            if(i > r){
                // l,r is behind i so update l,r
                l = r = i;
                // r pe chrcter as r-l i.e shruwat se window same h to inc r++
                while(r < z.length && str.charAt(r) == str.charAt(r - l)){
                    r++;
                }
                //mismatches go back and add it to zarray 
                r--;
                z[i] = r - l + 1;
            } else {
                //i l se r ki window ke beech me h
                int k = i - l;//i left se kitna aagey h 
                if(z[k] == r - i + 1){
                    //z[k] window me nhi h
                    l = i;//move left to i
                    while(r < z.length && str.charAt(r) == str.charAt(r - l)){
                        r++;
                    }
                    r--;
                    z[i] = r - l + 1;
                } else {
                    //same z[i] to z[k] if it is window 
                    z[i] = z[k];
                }
            }
        }       
        int count = 0;
        for(int val: z){
            //get those who have same z-value as same as pattern.length
            if(val == p.length()){
                count++;
            }
        }
        
        return count;
	}

}