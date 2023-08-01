// Link -> https://leetcode.com/problems/ways-to-make-a-fair-array/
//return number of elements to remove so that sum of odd-indexed values equals the sum of even-indexed values

/* Approach:
1.parse on array calculate odd sum and even sum
2.again parse on array and calcule left odd and even sum and right odd and even sum
3.if removing element is even => ro=os-lo & re=es-le-ce and check if le + ro = lo + re if true inc the counter
4.if removing element is odd => ro=os-lo-co & re=es-le and check if le + ro = lo + re if true inc the counter
       i i i
arr -> a b c d e f g h
       0 1 2 3 4 5 6 7
    os = bdfh      lo = b if we remove c right side ke original even the unka sum nikalne ke liye es - le -ce
    es = aceg      le = a   ro = os - lo

    le + ro  = lo + re -> bcz ek remove hone se index badal jayege even odd ho gye 
      
      i
arr-> 2 1 6 4
      0 1 2 3
es = 8   2-> ro = os-lo=5,re=es-le-ce=9-2=6,lo+re = le+ro => 0+6 != 5+2 -> not fair
os = 5  1-> ro= os - lo-co=4,re= es-le=8-2=6  lo+re = le + ro => 0+6=2+4 -> fair
*/
class Solution {
    public int waysToMakeFair(int[] nums) {
        int os = 0; //odd sum
        int es = 0; //even sum
        
        for(int i = 0;i < nums.length;i++){
            //get odd and even sum
            if(i % 2 == 0){
                es += nums[i];
            } else {
                os += nums[i]; 
            }
        }
        int los = 0; // left odd sum
        int les = 0; // left even sum
        int ans = 0;
        
        for(int i = 0;i < nums.length;i++) {
            if(i % 2 == 0) {
                //if removing element is even
                int res = es - les - nums[i]; //right even sum
                int ros = os - los;//right odd sum
                if(los + res == les + ros) {
                    ans++;
                }
                les += nums[i];
            } else {
                //if removing element is odd
                int res = es - les;
                int ros = os - los - nums[i];
                if(los + res == les + ros) {
                    ans++;
                }
                los += nums[i];
            }
        }
        return ans;
    }
}