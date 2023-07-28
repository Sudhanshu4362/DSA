// link : https://leetcode.com/problems/next-greater-element-iii/
//  smallest greater integer -> choto me sabsa bda number kya bna skte h using the same digit i.e first greater number
// for e.g -> 683486532 for this 683523468 is the answer

/*
approach ->
1) start from last and move towards 0 if greater number found move on and stop on first smaller number found
6 8 3 4 8 6 5 3 2 start from 2->3, 3 ->5,5 -> 6,6 -> 8,8 -> 4 now its first decreasing stop store 4 
2) again from end and find first greater number then 4 i.e 2 < 4,3 < 4,5 > 4 now 5 is greater swap 4,5
3) now our number is 6 8 3 5 8 6 4 3 2 and reverse 8,6,4,3,2 -> 2,3,4,6,8 
our answer is 6 8 3 5 2 3 4 6 8
*/
//why -> if no is increasing then smallest greater integer is not possible
// in last of number 10 to the power is less so change in number will be less

//code
class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int i = arr.length - 1;
        while(i > 0) {
            if(arr[i - 1] >= arr[i]){
                i--;
            } else {
                break;
            }
        }
        if(i == 0) {
            return -1;
        }
        int idx1 = i - 1;
        int j = arr.length - 1;
        while(j > idx1) {
            if(arr[j] > arr[idx1]){
               break;
            }
            j--;
        }
        //swap
        swap(arr,idx1,j);
        //rev from end to i
        int left = i;
        int right = arr.length - 1;
        while(left < right) {
            swap(arr,left,right);
            left++;
            right--;
        }
        String res = new String(arr);
        long val = Long.parseLong(res);
        return(val > Integer.MAX_VALUE ? -1 : (int) val);
    }
    void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}