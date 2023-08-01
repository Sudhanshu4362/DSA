// Link -> https://practice.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// find maximum sum of smallest and second smallest elements chosen from all possible sub-arrays

/* Approach :
arr -> a  b  c  d  e
ans can be a+b,b+c,c+d,d+e 
why -> let our ans is b + e i.e c + e greater then b + e i.e b + c > b + e i.e c and d cant exist bcz if they exist
they will give max sum
*/

class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        // Your code goes here
        long ans = 0;
        for(int i = 0;i < N-1;i++){
            if(arr[i] + arr[i+1] > ans){
                ans = arr[i] + arr[i+1];
            }
        }
        return ans;
    }
}