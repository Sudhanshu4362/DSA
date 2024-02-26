// arr => 10,20,30,40,50 target = 70
// ans  => 10,20,40 and 20,50 and  30,40

/*Approach:
1st level pe 10 decison lega ki set ka hissa hoga ki nhi



             30/10,20/30    30/20/20
                \       /   \       /
                20/10/10     20/./0
                  t\         /f
                     10 / . /0
                     num/set/sum

*/

// code
class Solution {
    public static void TSS(int[] arr,int idx,String set,int sos,int tar){
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ",");
            }
            return;
        }
        TSS(arr,idx + 1,set + arr[idx] +"," +sos + arr[idx],tar);
        TSS(arr,idx + 1,set,sos,tar);
    }
}