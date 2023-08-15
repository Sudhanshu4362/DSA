// https://www.codingninjas.com/studio/problems/highway-billboards_3125967 
//Install N boards at M kilometer road such that revenue is maximized and no two boards can be within in T miles

/* Approach: 
1.take x.length size dp array
1.place first board and check if we can install board at 7 or not since it is not more then 5 miles so ye akela lgega
3.loop on preveious boards and check with which it can add



 boards at ->   6   7      12  14  15 ,profit -> 5  8 5 3 1
                
              dp[] -> [5,8,5+5=10,3+8=11,1+8=9]  
 */
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
        int[] dp = new int[x.length];
        int omax = rev[0];
        dp[0] = rev[0];
        for(int i = 1; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                //loop on prev.boards to that board
                if(x[j] + t < x[i]){
                    //if it is after t miles
                    max = Math.max(max, dp[j]);
                }
            }
            
            dp[i] = max + rev[i];
            omax = Math.max(omax, dp[i]);
        }
        
        return omax;
    }
}