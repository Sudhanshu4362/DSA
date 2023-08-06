// Link -> https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1

// sort the array such that it forms wave like form 
/* Approach:
Swap the values at odd oven 
1.loop for every second position and swap it with previous one

1 2 3 4 5
2 1 4 3 5
*/

class Solution {
    public static void convertToWave(int n, int[] a) {
        Arrays.sort(a);
        for(int i = 0;i < a.length;i+=2){
            if(i < a.length - 1){
                int temp = a[i + 1];
                a[i + 1] = a[i];
                a[i] = temp;
            }
        }
    }
}