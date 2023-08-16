// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// given an array of non-negative integer values and a target integer value return the sets having sum equal to
//target  

/* Approach:
Intituion-> first exclude that element and check if previous elemnt can make the target or include the element
and check if previous element can make target-element.if any true means target is possible.
Approche:
 1.create boolean dp[][] array
 2.loop from i to dp.length
 3.for 0 and X i.e 0th row and col make true 
 4.rest of 0 row is false as targets are not possible without selecting single element and rest og 0th col -> true
 5.onwards check if dp[i-1][j] i.e same col but prev row is true or not if true dp[i][j] pe true else check if 
 sum-elemen is possible or not.
 6.if we include that number then check j-that number is possible or not.
  
 i      0 1 2 3 4 5 6 7 8 9 10 -> sums
 0   X  T X X X X X X X X X  X 
 1   4  T X X X T X X X X X  X 
 2   2  T X T X T X T X X X  X
 3   7  T X T X T X T T X T  X
 4   1  T T T T T T T T T T  T
 5   3  T T T T T T T T T T  T
 * dp ka 1 array ke 0 ko coincide krta h 
  meaning of dp -> at any point does nums array having any subset of that target 
  every element can make zero sum and we can not create sum other then zero by not selecting  single element
  only 4 -> only 0(by not selecting 4) sum and 4 sum we can make by selecting 4 
  till 4,2-> we can select 2 or not select if we not select 2 then we check if 4 tak ka array can make sum or not
             for e.g at 6 if we not select 2 then we check 4 6 bna skta h ya nhi ya 2 ko include krke 6 sum bna skta h ya nhi
             h ya nhi. at 4 if we not consider 2 then 4 tak ka array bna skta h ya nhi 
             so if we are  selecting 2 then check in prev. row if sum-2 is true in prev.row
             but if we are not selecting 2 then check if sum is possible inprev row or not

             so we are check direct prev row and prev row me sum-val pe jake dekhege if any true i.e sum is possible
            

| 
*/

class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 && j == 0){
                    //1st cell
                    dp[i][j] = true;
                } else if(i == 0){
                    // 1st row
                    dp[i][j] = false;
                } else if(j == 0){
                    // 1st column
                    dp[i][j] = true;
                } else {
                    if(dp[i - 1][j] == true){ //excluding curr number -> check pichla row same column
                        dp[i][j] = true;
                    } else {//include
                        int curr = arr[i - 1];//current item in array.dp[i] coincides with arr[i-1]
                        if(j >= curr){ // agar j curr se bda h ya nhi
                            if(dp[i - 1][j - curr] == true){//pichla row but for target-element column i.ej-curr
                                dp[i][j] = true;
                            } else {
                                dp[i][j] = false;
                            }
                        }
                    }
                    
                }
            }
        }
        
        return dp[arr.length][tar];
    }
}