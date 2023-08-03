// Link - https://www.interviewbit.com/problems/allocate-books/
/* N books -> ith book has A[i] no of pages,allocate books to B no of students so that max no of pages allocated to
a student is minimum
*/

/* Approach : similar to split array largest prolem
1.get hi as all pages i.e sum of all elements
2.lo as max value in array -> max pages wali book 
3.calculate mid 
4.count of students and curr pages to check how many students needed according to this allotment
5.loop on array and calculate currpage if it exceeds allotment inc the count of students
6.if req student is greater then given student i.e allotement is less inc it by going to right side else left side

*/

public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        if(A.size() < B){
            return -1;
        }
        
        int lo = Integer.MIN_VALUE;//max pages wali book
        int hi = 0; //agr ek hi sari pdhe
        for(int val: A){
            lo = Math.max(val, lo);
            hi += val;
        }
        
        while(lo < hi){
            int allot = (lo + hi) / 2;
            
            int reqd = 1;//no of student required
            int curr = 0; //sum of currpages
            for(int val: A){
                if(curr + val <= allot){
                    curr = curr + val;
                } else {
                    // no of pages exceeds allot of pages
                    curr = val;
                    reqd++;
                }
            }
            
            if(reqd > B){
                // alloted page is less increase it -> right side
                lo = allot + 1;
            }  else {
                hi = allot;
            }
        }
        
        return lo;
    }
}