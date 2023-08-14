//
// 1 to N jumps allowed

/* Approach:
1.climb 1 to N stairs 
2.small problem is N to N jane ka tarika


jumps->    3    3    0   2    1    2    4     2   0    0

                                  dp<----------------
indexes -> 0   |1   |2   |3   |4   |5   |6   |7   |8   |9   |10
dp[] ->    5   |3   |0   |2   |1   |1   |1   |0   |0   |0   |1
          0-10 |1-10|2-10|3-10|4-10|5-10|6-10|7-10|8-10|9-10|10-10 -> kha se kha jane ke trike                      
1-> 10-10 jane ke 1 trika h chlo hi mat
2->9-10 nhi ja skte 0 jumps h 9 se similary for 8
3->7 se 2 jump allowed h we can reach 7 and 8 but therefrom no route to 10 se from seven also we cant go to 10
4->6 se 4 jumps 6-7,6-8,6-9,6-10 ja skte h but baki 3 se koi route mhi h so 6-10 jane ka 1 way h
5->5 se 2 jumps allowed we can reach 6 and 7 so 5-10 ka ek route h 5-6-10 pehle 1 ka jump then 4 ka from 6
6->3 se 2 jumps we can reach 4 and 5 and both have 1 ,1 ways so total 2 ways
*/

public class Main {
    public static int climbStairsVairable(int[] arr,int n){
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n-1;i >= 0;i++){
            dp[i] = 0;
            for(int j = i + 1;j <= i + arr[i];j++){
                //jumps allowed from jumps array
                if(j < dp.length) {
                    dp[i] = dp[i] + dp[j];
                }
            }
        }
        return dp[0];
    }
}