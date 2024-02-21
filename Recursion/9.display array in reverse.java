// 50 40 30 20 10

/* Approach :
Exp => d(a,0) => 50 40 30 20 10
faith => d(a,1) => 50 40 30 20 
EWF => d(a,1).10

*/

class Solution {
    function displayArr(int[] arr,int idx){
        if(i == arr.length) {
            return;
        }
        displayArr(arr,idx + 1)
        System.out.println(arr[idx]);
    }
}