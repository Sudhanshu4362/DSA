// link -> https://leetcode.com/problems/maximum-swap/
// You are given an integer num. You can swap two digits at most once to get the maximum valued number.
// Return the maximum valued number you can get.

/* 
intituion -> right side me jo sabse bda number h usse swap hone me fyda h!
Approach -> 
1.Convert num to char array
2.Create a array which stores index of maximum value in right
3.Now traverse on array check if arr[i] < arr[right[i]] if true then swap

nums->  9 5 3 8 4 6 7 2
idx ->  0 1 2 3 4 5 6 7
right-> 3 3 3 6 6 6 2 -1
*/

// code
class Solution {
    public int maximumSwap(int num) {
        char[] arr = (num +"").toCharArray();
        
        int[] right = new int[arr.length];
        for(int i = arr.length - 1;i >= 0;i--) {
            if(i == arr.length - 1) {
                right[i] = -1;
            } else if(i == arr.length - 2) {
                right[i] = arr.length -1;
            } else {
                if(arr[i + 1] > arr[right[i + 1]]){
                    right[i] = i + 1;//if greater number is present then update
                } else {
                    //else continue previous max
                    right[i] = right[i + 1];
                }
            }
        }
        for(int i = 0;i < arr.length -1;i++) {
            if(arr[i] < arr[right[i]]) {
                char temp = arr[i];
                arr[i] = arr[right[i]];
                arr[right[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }
}