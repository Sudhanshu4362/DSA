// Link -> https://leetcode.com/problems/count-of-smaller-numbers-after-self/

/* Approach:
1.use Merge sort
2.while merging check for smaller on right and count them 
3.while merging left and right me jo bda hoga use pehle lenge to store greater no first then smaller
          18  15    13 11           12  14         16  17 
            \/       \/                \ /           \ /
          18 15[18,15] 13 11[13,11]    12 14[14,12]  16 17[17,16]
                \      /                     \       /
            18 15  13 11[18,15,13,11]      12 14  16 17[17,16,14,12]
                        \                  /
                     18 15 13  11   12 14 16 17[18,17,16,15,14,13,12,11]
    
    ans -> [1+2+4,2+2, 1+1              ]-> [7,4,2,0,0,0,0,0]
             18,  15,  13, 11,12,14,16,17
        jab 18,15 process hua toh ek usse chota mil gya  array me jake 18 pe +1 kr dege
        vo chote dene h jo right side pe h i.e on one array
         i                   j 
        [18 15 13 11]  and [17 16 14 12] jab ye merge honge tab 18 and 17 me 18 bda h toh 17 16 14 12 sare chote h
        and right me h and count = two.len - j = 4 - 0 = 4 chote h second half me

*/

class Solution {
    Integer[] ans;
    
    class Pair {//to store value and index of that
        int val;
        int idx;
        
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        ans = new Integer[nums.length];
        Arrays.fill(ans, 0);
        
        Pair[] pairs = new Pair[nums.length];//isko sort krege
        for(int i = 0; i < nums.length; i++){
            pairs[i] = new Pair(nums[i], i);
        }
        mergeSort(pairs, 0, pairs.length - 1);
        
        return Arrays.asList(ans);
    }
    
    Pair[] mergeSort(Pair[] arr, int lo, int hi){
        if(lo == hi){
            Pair[] barr = new Pair[1];
            barr[0] = new Pair(arr[lo].val, arr[lo].idx);
            return barr;
        }
        
        int mid = (lo + hi) / 2;
        
        Pair[] sfhalf = mergeSort(arr, lo, mid);
        Pair[] sshalf = mergeSort(arr, mid + 1, hi);
        Pair[] sarr = mergeTwoSortedArrays(sfhalf, sshalf);
        return sarr;
    }
    
    Pair[] mergeTwoSortedArrays(Pair[] one, Pair[] two){
        Pair[] res = new Pair[one.length  + two.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < one.length && j < two.length){
            if(one[i].val > two[j].val){
                //first half ki value > second half
                res[k] = one[i];
                //kha pe dalne h -> first half wale ke index pe i.e 18 ke liye 0,second half ki length - j
                ans[one[i].idx] += two.length - j;//add smaller count in ans at one[i].idx
                
                k++;
                i++;   
            } else {
                res[k] = two[j];
                k++;
                j++;
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
Console
