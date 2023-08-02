// Link-> https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

/* Approach :
1.Push negative numbers in list while processing nums array
2.Process k -1 elements and do nothing Put d in list and we will start printing our answer from next element 
3.e ke liye ans list me jo pehla bnda h 
REMOVE -> INSERT -> ANS

A ->  a  b  c  -d  e f -g -h i j -k -l -m n o -p q -r s t u w
ans->              d d  d  d g g  g  h  k k k  l m  
deque-> d g h-> g h k -> h k l -> k l m -> l m p
1.process k-1 elements and add negative elements
2.e pe window complete ho rhi h so e pe ans ke top me jo hoga vo answer hoga i.e d
3. while process first we check if d is in range or not
4.g ko process krne pe usko list me dal denge but check if d is in range to uska first -ve vhi hoga if not remove d
*/


//USING 2 POINTER
/*
1.two pointers i and j at zero
2.j will move till first negative in range 
3.for every i we will print answer as j if it is in range
4.if j is not in range move till it is in not in range 
      i  i  i   i  i i  i  i i i
A ->  a  b  c  -d  e f -g -h i j -k -l -m n o -p q -r s t u w
      j  j  j   j  j j  j
ans-> d d  d  d d  d d  d  d g g
*/
class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] ans = new long[N - K + 1];
        int j = 0;
        for(int i = 0; i <= N - K; i++){
            if(j < i){
                //if j is behind i move j to i
                j = i;
            }
            
            while(j < i + K - 1 && A[j] >= 0){
                // move j till j is not in range 
                j++;
            }
            
            if(A[j] < 0){
                //ans[i] me j pe jo h vo answer dalenge
                ans[i] = A[j];
            }
        }
        
        return ans;
    }
}