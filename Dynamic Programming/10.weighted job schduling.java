//  Link -> https://leetcode.com/problems/maximum-profit-in-job-scheduling/

/* N jobs[start -> end time] -> profit[i] return the max profit you can take s.t there is no two jobs in the subset
with overlapping time i.e no two collide.
*/

/* Approach:
 1. sort the start time and take lis and check pehle wala ka finish aapke strt se kam ho
 2. store profit in lis this time

       Job 1:  {1, 2, 50}   -> j1{1->2,50}
       Job 2:  {3, 5, 20}   -> j1 and j4(1->2,2->100,200+50=250)
       Job 3:  {6, 19, 100} ->
       Job 4:  {2, 100, 200}

       after sorting on start time
       Job 1:  {1, 2, 50}      ->   j1{1->2,50}
       Job 4:  {2, 100, 200}   ->   j1 and j4(1->2,2->100,200+50=250)  -> max profit
       Job 2:  {3, 5, 20}      ->   j1 and j2(1->2,3->5,50+20=70)
       Job 3:  {6, 19, 100}    ->   j1 andj2 and j3 (1-2,3-5,6-8 , 170)

       for j1 and j4 start of j4 is greater then equal to j1 so we can perform that job and add profits(time-1-100)
       for j2 and j1 j2 j1 ke bad kiya ja skta h but not with j4 as overlapping
       j1,j2,j3 are non overlapping
*/

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][3];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        
        Arrays.sort(arr, (b1, b2) -> {
	        if(b1[0] != b2[0]){
	            return b1[0] - b2[0];
	        } else {
	            return b1[1] - b2[1];
	        }
	    });
	    
	    int[] lis = new int[arr.length];
	    lis[0] = arr[0][2];
	    
	    for(int i = 1; i < arr.length; i++){
	        int max = 0;
	        for(int j = 0; j < i; j++){
	            if(arr[j][1] <= arr[i][0]){
	                max = Math.max(max, lis[j]);
	            }
	        }
	        
	        lis[i] = max + arr[i][2];
	    }
	    
	    int len = 0;
	    for(int val: lis){
	        len = Math.max(len, val);
	    }
	    
	    return len;
    }
}