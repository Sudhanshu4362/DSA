// link-> https://leetcode.com/problems/sort-the-matrix-diagonally/

/* Approach
i  0 1 2 3 4 <- j
0  3 2 7 5 2
1  6 5 3 2 8
2  2 7 9 6 5
3  3 9 5 3 10

i-j -> is common for a diagonal -> gap
gap -> pq
0 ->3,5,9,3          1->6,7,5
-1->2,3,6,10         2->2,9
-2->7,2,5            3->3
-3->5,8              
-4->2

1.Maintain a Hashmap of priorityQueue gap vs pq
2.again loop in array jo gap aaye us pq me se remove kre and refill the matrix
*/

// code ->
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i =0;i < m;i++){
            for(int j = 0;j < n;j++) {
                int gap = i -j;
                if(!map.containsKey(gap)) {
                    map.put(gap,new PriorityQueue<>());
                }
                map.get(gap).add(mat[i][j]);
            }
        }
        
        //re filling matrix
         for(int i =0;i < m;i++){
            for(int j = 0;j < n;j++) {
                int gap = i -j;
                mat[i][j] = map.get(gap).remove();
            }
        }
        return mat;
    }
}