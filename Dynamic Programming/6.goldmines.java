class Solution{
    static int maxGold(int n, int m, int arr[][]){
       if(n==1){
           int sum=0;
           for(int i=m-1;i>=0;i--){
              sum += arr[0][i];
           }
          return sum;
        }
       int[][] dp = new int[n][m];
       for(int j = dp[0].length - 1;j >= 0;j--){
          for(int i = dp.length - 1;i >= 0;i--){
             if(j == arr[0].length - 1){
                  dp[i][j] = arr[i][j];
              } else if(i == 0){
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
              } else if(i == arr.length - 1){
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
              } else {
                  dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
              }
        }
       }
      int max = dp[0][0];
      for(int i = 1; i < dp.length; i++){
          if(dp[i][0] > max){
              max = dp[i][0];
          }
      }
      return max;
    }
}