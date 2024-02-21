

// arr = 10 20 30 40 50
/* Approach : 
 Exp => d(a,0) =>10 20 30 40 50
 faith => d(a,1) =>20 30 40 50
 EWF => 10 .d(a,1)
*/

class Solution {
    function displayArr(int[] arr,int idx){
        if(i == arr.length) {
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr,idx + 1)
    }
}
