// Link -> https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
// k lists of sorted integers in non-decreasing order
//Find the smallest range that includes at least one number from each of the k lists.

/*
Approach:
1.Make PQ and add 1 element from each list and a max variable containing max of pq
2.Remove 1 from pq and compute range as max - min(removed)
3.now add 1 new element from that list whose element is removed and update max if greater number added
4.again remove from pq and check if range is better or not

          i  i            j j         k
list -> [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
1.4,0,5 added and max = 5
2.0 is removed and range -> [0,5]
3.9 is added and new max is 9
4.4 is removed check if [4,9] is better range then [0,5] which is not so dont update it                         
*/
//code:
class Solution {
    class Pair implements Comparable<Pair>{
        int li;//list index -> from which list
        int di;//data index -> which index in list
        int val;//value
        
        Pair(int li,int di,int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.size();i++) {
            // putting 1st element from each list in pq
            // i - list index,0 - data index,nums.get(i).get(0) -> value milegi 
            pq.add(new Pair(i,0,nums.get(i).get(0)));
            max = Math.max(max,nums.get(i).get(0));
        }
        
        int rbeg = 0;//range beg
        int rend = 0;//range end
        int rsize = Integer.MAX_VALUE;//range size
        
        while(pq.size() == nums.size()) {
            //jab tak har ek list ka 1 pq me h
            Pair p = pq.remove();
            //curr size of range
            int csize = max - p.val;
            //choti range pe update krege
            if(csize < rsize){
                rsize = csize;
                rbeg = p.val;
                rend = max;
            }
            //same list ka next element
            //p ka data index should be smaller then list ke size se
            if(p.di < nums.get(p.li).size() - 1) {
                p.di++;
                p.val = nums.get(p.li).get(p.di);
                pq.add(p);
                //update max while adding
                if(p.val > max) {
                    max = p.val;
                }
            }
        }
        return new int[]{rbeg,rend};
    }
}