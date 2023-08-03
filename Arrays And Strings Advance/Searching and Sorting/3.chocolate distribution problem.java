// Link -> https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
// given N chocolates distribute it inton students each student get 1 packet
// the diff b/w packet with max chocolate and packet with min is minimum

/* Approach :
1.Sort the array
2.no of student size ki window lelo
3. end at m -1 and start at e - m + 1
3.check min and max gap b/w them

choco -> 3 4 1 9 56 7 9  12   ,5 students
         s s s s
sort ->  1 3 4 7 9  9 12 56
                 e  e  e  e
                 8  6  8  49 -> min 6

*/

// code
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int ans = Integer.MAX_VALUE;
        for(int e = m - 1;e < a.size();e++){
            int st = e - m + 1;
            int diff = a.get(e) - a.get(st);
            ans = Math.min(ans,diff);
        }
        return ans;
    }

}