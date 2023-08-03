// Link -> https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
// [merge sort based]
// how far an array from being sorted

// intituon -> while merge sort we will count inversions
/* Approach :
   1.merge sort the array
   2.while merging whenever if you use element from second array i.e inversion occured for e.g 8,5 ke liye 5 pehle
   uthayege then 8 while merging i.e add length - index to result
  8  5      3  1   2  4  6 7
   \/        \/     \/   \/
   85[58]   31[13]  24[24]  67[67]
     \    /              \    /
    8 5 3 1[1358]        2 4  6 7[2467]
           \          /
     8   5   3  1   2  4  6  7[]

     inversions -> 
     1st inv -> 8,5
     2nd inv -> 3,1
     3rd inv -> 5,1 
     4       -> 8,1
     5       -> 5,3
     6       -> 8,3
     +3      -> 32,52,82
     +2      -> 54,84
     +2      -> 86,87
      ii         j
     [1358] and [2467]
     invs = len - 1 = 4-1 =3[32,52,82]
*/

class Solution
{
    static long ans = 0;
    static long inversionCount(long arr[], long N)
    {
        ans = 0;
        mergeSort(arr, 0, arr.length - 1);
        return ans;
    }
    
    static long[] mergeSort(long[] arr, int lo, int hi){
        if(lo == hi){
            long[] barr = new long[1];
            barr[0] = arr[(int)lo];
            return barr;
        }
        
        int mid = (lo + hi) / 2;
        
        long[] sfhalf = mergeSort(arr, lo, mid);//sorted first half
        long[] sshalf = mergeSort(arr, mid + 1, hi); //sorted second half
        long[] sarr = mergeTwoSortedArrays(sfhalf, sshalf); //merging both the arrays
        return sarr;
    }
    
    static long[] mergeTwoSortedArrays(long[] one, long[] two){
        long[] res = new long[one.length  + two.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < one.length && j < two.length){
            if(one[i] <= two[j]){
                //one[i] chota h two[j] se
                res[k] = one[i];
                k++;
                i++;
            } else {
                // two[i] chota h
                res[k] = two[j];
                k++;
                j++;
                //jab ham second array se pehle le rhe h 
                ans += (one.length - i);//inversions
            }
        }
        
        while(i < one.length){
            res[k] = one[i];
            k++;
            i++;
        }
        
        while(j < two.length){
            res[k] = two[j];
            k++;
            j++;            
        }
        
        return res;
    }
}