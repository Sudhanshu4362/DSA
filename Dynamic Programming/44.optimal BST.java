// https://practice.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1 
// catalan number + MCM
// given two sorted arrays search keys and freq[] of freq. count where freq[i] is number of searches to keys[i] construct the BST of all keys such that the total cost of all the searches is as small as possible 
// cost of a BST node is level of that node multiplied by its frequency,level of root is 1
/* Approach:
 1. create prefix sum array of frequencies
 2. now use gap startegy as discussed
 3. for g = 0 only one root node toh ans will be freq[i]
 4. for g = 1 only 2 nodes and 2 possible trees so ans will be min(1*fre[i]+2*freq[j],1*freq[j]+2*freq[i])
 5. for g > 1 now calculate left and rights with special case here as k2 start from g+1 and k1 end beyound g and factor will be calculated as psa[j]-psa[i-1] -> to get sum of freq. in perticular range
 6.take min of all

values -> a,b,c
s.cost -> a',b',c' -> a ko a' bar search kiya h,b ko b' bar..
ek search ki cost is -> height of node in tree * freq. i.e  a= 1*freq

values -> 10,20,30,40,50
s.cost -> 2,3,1,5,4
[alag alag bst ke liye alag alag cost aayegi we have to take min.]

        10     20      30      40       50
j-5      j-4   j-3     j-2      j-1      j  k2->g+1 se 1 ki taraf
    10   10-2  1020-7  102030-  10203040  1020304050  i,j
 
    20     X     20-3   2030-5   203040   20304050    i+1,j

    30     X      X       30-1   3040-7    304050     i+2,j

    40     X      X       X        40-5    4050-13    i+3,j  

    50     X      X       X        X        50-4       i+4,j

                                                     i+5,j,k1 1 se start hoke neeche move ho rha
  1020 ke liye 2 hi tree possible h if 10 is root then cost is 2 + 3*2 = 8 and if 20 is root then 3+2*2 = 7 in which 7 is minimum cost
  for 102030 ->  if 10 is root then left me kuch nhi and right me 20304050 and so on increase the pointers and take min cost for each root          
*/

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int[][] dp = new int[keys.length][keys.length];
        int[] psa = new int[freq.length];//prefix sum array of frequencies
        psa[0] = freq[0];
        for(int i = 1; i < freq.length; i++){
            psa[i] = psa[i - 1] + freq[i];
        }
        
        for(int g = 0; g < dp[0].length; g++){
            for(int i = 0, j = g; j < dp[0].length; i++, j++){
                if(g == 0){
                    // only one node -> root node
                    dp[i][j] = freq[i];
                } else if(g == 1){
                    //2 node -> 2 hi bst is possible take min of that
                    dp[i][j] = Math.min(1 * freq[i] + 2 * freq[j], 2 * freq[i] + 1 * freq[j]);
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    
                    for(int k2 = g + 1, k1 = 1; k2 >= 1; k2--, k1++){
                        int left = (j - k2) == -1? 0: dp[i][j - k2];
                        int right = (i + k1) == dp.length? 0: dp[i + k1][j];
                        int factor = psa[j] - (i > 0? psa[i - 1]: 0); //some of frequencies 
                        
                        dp[i][j] = Math.min(dp[i][j], left + right + factor);
                    }
                }
            }
        }
        
        return dp[0][dp[0].length - 1];
    }
}