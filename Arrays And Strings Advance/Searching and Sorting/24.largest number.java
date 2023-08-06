// link -> https://leetcode.com/problems/largest-number/

// arrange elements of array such that they form largest number(return in string)
//send that element to last whos is making smaller number
/* Approach:
1.get String array
2.get a,b and get a + b and b + a in string i.e for e.g 3,30 a + b = 330 and b+ a = 303 so 330 > 303 so pehle 3 
aayega then 30 else 30 pehle then 3

arr -> 3  30  34  5  9
   1-> 3  34  5   9  30 -> 3,30 me 330 and 30 & 34 me 3430 is large so append 34 first to 30 and so on for all
   2-> 34  5  9   3  30
   3-> 5   9  34  3  30
   4-> 9   5  34  3  30 -> largest number
*/

class Solution {
    public String largestNumber(int[] nums) {
        String[] sarr = new String[nums.length]; //convert int array to string 
        for(int i = 0;i < nums.length;i++){
            sarr[i] = nums[i] + "";
        }
        Arrays.sort(sarr,(a,b) -> {
            String case1 = a + b;
            String case2 = b + a;
            return case2.compareTo(case1); // return largest first 
        });
        if(sarr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : sarr) {
            sb.append(s);
        }
        return sb.toString();
    }
}