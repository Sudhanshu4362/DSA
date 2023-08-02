// Link -> https://leetcode.com/problems/push-dominoes/
//n dominos in line 
// domn[i] == 'L' -> domino pushed to left
// domino[i] == 'R'->domino pushed to right
// domino[i] = '.' -> not pushed

/* Approach
1.To handle start and end start me left and last me right end kr dege
2.convert string to character array and a pointer pi = 0
3.loop on array if LL loop and all left
4.LL-all left,LR -do nothing,RR-all right,RL-nearest impact


    <-         <-        ->        ->     <-    
p       p         p       p         p       p
L . . . L . . . . L . . . R . . . . R . . . L . . . R
  i i i i i i i i i i i i i i i i i i i i i i i i i i
i pe L hai and pi pe bhi left to sare left kr do pi + 1 se i tak loop se and update pi to i
now i pe R h and pi pe L then do nothing
R-R ke case me sare R
now i pe L h and pi pe R so lo hi rkh ke loop lga ke update krege

L L L L L L L L L L . . . R R R R R R R . L L . . . R

 left ke sare left wale left ho jayege
 right ke right wale right ho jayege
 if both are impacting l and r then nearest wale vo change kr dege and same distance wale intact rh jayege

*/



// code
class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        int pi = 0;//previous index
        char[] arr = dominoes.toCharArray();
        
        for(int i = 0;i < arr.length;i++) {
            if(arr[i] == 'R'){
                //hamra 'R' h and prevoius idx 'L' pe h i.e LR wala case
                if(arr[pi] == 'L') {
                    //do nothing
                } else if(arr[pi] == 'R') {
                    for(int x = pi + 1;x < i;x++) {
                        arr[x] = 'R';
                    }
                }
                pi = i;
            } else if(arr[i] == 'L') {
                if(arr[pi] == 'L') {
                    for(int x = pi + 1;x < i;x++) {
                        arr[x] = 'L';
                    }
                } else if(arr[pi] == 'R') {
                    int left = pi + 1;
                    int right = i - 1;
                    
                    while(left < right) {
                        arr[left] = 'R';
                        arr[right] = 'L';
                        left++;
                        right--;
                    }
                }
                pi = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        //loop from 1 to size-1 to remove those character we have added
        for(int i = 1;i < arr.length - 1;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}