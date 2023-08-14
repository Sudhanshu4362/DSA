
// same problem as variable jump but one change we have to get min moves not total no of ways

/* Approach:
  
  jumps-> 3   2   4   2   0   2   3   1   1   2   2
                                        dp<---------       
          0   1   2   3   4   5   6   7   8   9   10  
  dp[] -> 4   4   3   4   N   3   2   2   2   1    X

1->10-10 jane ka min tarika h 0 
2->9-10 jane ka 1 trika h,8-10 jane ka bhi ek tarika h
3->7 se 8 ja skte h and vha se 10 so 1 + 1 = 2 ways


*/

public class Main {
    public static int climbStairsVairable(int[] arr,int n){
        int[] dp = new Integer[n + 1];
        dp[n] = 0;
        for(int i = n-1;i >= 0;i++){
            if(arr[i] > 0){
                //if jumps h toh ja skte h aaagey
                int min = Integer.MAX_VALUE;
                for(int j = i + 1;j <= i + arr[i];j++){
                    if(dp[i + j] != null){
                        //calculate min jumps from all jumps allowed 
                        min = Math.min(min,dp[i+j]);
                    }
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}