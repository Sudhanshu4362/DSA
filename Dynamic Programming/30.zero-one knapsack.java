// TSS
// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1 
//given bags with weights of items init find out find out max value subset of val such that weights of this subset is smaller then given capacity
// 0/1 knapsack -> only two choice item ko bag me dal skte h ya nhi

/* Approach:
meaning -> at last row and col meaning is using all tha value how we can we make in 7kg
Intituiton -> base on inclusion and exclusion of elements.
  1.dp of [n+1][cap + 1]
  2.now for first row and col set zeros 
  3.get idx as i-1 wt as wts[idx] and val as val[idx] bcz dp is 1 index ahead of given arrays 
  4.now check if j is sufficient or not if not add values from previous row 
  5.if j is sufficient then get max by excluding or including current bag 

  val -> 15 14 10 45 30    bag capacity -> 7kg return max value created val@wts
  wt ->   2  5  1  3  4  

         0   1   2   3   4   5   6   7
     X   0   0   0   0   0   0   0   0 
   15@2  0   0   15  15  15  15  15  15
   14@5  0   0   15  15  15  15  15  29 
   10@1  0   10  15  25  25  25  25  29
   45@3  0   10  15  45  55  60  70  70
   30@4  0   10  15  45  55  60  70  75

   0kg bag me 0 kg hi bna skte h  and without selecting any bag we can make 0 wt -> 1st row and col will be 0
   till 15@2 we for we cant devide wts and for 2 onwards capac. we can make 15 only
   At 14@5 till 5 capac. we cant add from this bag so add from prev row as its but after 5 we check if only using this bag or not using this bag if we use this bag max will be 14 but if we don't use this bag then max will be 15 so we get value from prev row but at 7 if we use 14@5 then we will we left with 2 remaining capacity so use it to and we get 29
   at last row,col -> if 30 wale ko bag me nhi dala toh remianing 7 pe previous wle 70 bnate h but if we include it then 30 at 4 + 45 at 3 = 75
*/

class Solution 
{ 
    static int knapSack(int W, int wts[], int value[], int n) 
    { 
        int[][] dp = new int[n+1][W+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int idx = i - 1;// get alligned index of arrays from dp
                int wt = wts[idx];
                int val = value[idx];
                if( j >= wt){ //if j is sufficent then get max from incliding or exluding from prev row
                    dp[i][j] = Math.max(val + dp[i-1][j-wt], dp[i-1][j]);
                } else {
                    // j is not sufficent get values from prev row
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    } 
}