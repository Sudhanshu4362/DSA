// link -> https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
// Given arrival and departure times of all trains that reach a railway station. 
// Find the minimum number of platforms required for the railway station so that no train is kept waiting.

/* Approach->
1.sort arr and dep 
2.loop on both arr if arr[i] is less then equal to dep[j] then increase i++ and inc the count of platform reqand if
train is departed dec the count of platform and at each arr and dep update max platform with count with max of it
3.i at 900 and j at 910 check for smaller if arr is less means arrival of train happend and move i to 940 next dep
is less means dep occured move the j to 1120 and dec the counter

         t1     t2    t3    t4    t5    t6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
         i       i    i     i     i     i
arr ->   900    940   950  1100  1500  1800
dep ->   910    1120  1130 1200  1900  2000
          j      i     j     j     j    j

c= 1-> 0 ->1 -> 2 -> 3- >2->1->0->1->2->1->0
max =1->2->3
*/

// code:
Arrays.sort(arr);
        Arrays.sort(dep);
        
        int count = 0;
        int max = 0;
        int i =0;
        int j = 0;
        while(i < arr.length &&j < dep.length){
            if(arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                j++;
                count--;
            }
            max = Math.max(count,max);
        }
        return max;