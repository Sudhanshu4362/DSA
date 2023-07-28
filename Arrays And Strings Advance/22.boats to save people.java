// link -> https://leetcode.com/problems/boats-to-save-people/

//intution -> try to board heavier people with least heavier people
/* Approach : 
1.Sort the Array
2.left at 0 and right at poeple.length -1
3.check for weight of people at left + right
4.if it is greater then limit only heavier people will board and move right pointer
5.if it is less then limit board both people and l++,r--
6.in the end if l == r increase boat count by 1.

people -> 3 2 2 1
            r r r
sorted -> 1 2 2 3
          l l
l+r = 4>3 only 3 will board and r--
l+r = 3 <= 3 both will board and l++,r--
l = r => 2 1 boat will be needed to board

*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sor
        int r = peoplet(people);
        int l = 0;.length - 1;
        while(l < r) {
            int val = people[l] + people[r];
            
            if(val <= limit) {
                ans++;
                l++;
                r--;
            } else {
                ans++;
                r--;
            }
        }
        if(l == r) {
            ans += 1;
        }
        return ans;
    }
}