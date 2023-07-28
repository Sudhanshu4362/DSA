// link -> https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

/* Approach:
1.Sort the given array
2.i = 1.j = 0 iterate over arr while i < arr.length
3. if diff kam aata h i bdha diff jyada kro and if jyada aata h to i bdha ke kam kro and i and j ko equal na hone do
if equal aata h toh i bdha do
4. if diff == n return true else false
       j j j  j  j  j j
arr -> 2 6 8 12 15 20 22 25 k = 7
         i i  i  i  i i   i
*/


class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        Arrays.sort(arr);
        int j = 0;
        int i = 1;
        
        while(i < arr.length){
            if(arr[i] - arr[j] > n) {
                j++;
                if(j == i) {
                    i++;
                }
            } else if (arr[i] - arr[j] < n) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}