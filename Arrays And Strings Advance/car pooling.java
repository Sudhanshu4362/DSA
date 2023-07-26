// link -> https://leetcode.com/problems/car-pooling/
// [[2,1,5],[3,3,7]] 
// 1st is passanger i.e 2 second is from third is two
// 2 from 1 to 5

/*approach 
1.A hashmap containing no of peoples at particular time (time -> persom) i.e on 1 two people will board at any 
time it exceeds capacity return false
2.Create arraylist of stops to parse in increasing order
3.add from and to in arraylist while putting in map in from add and in to subtract people
4.sort the stops
5.again loop in stop
6.a variable pic i.e people in car at moment
7. get delta from map.get(stop) add it to pic and check for capacity

time -> person
  1  -> +2
  3  -> +3
  5  -> -2
  7  -> -3
*/



// code
 class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> stops = new ArrayList<>();
        
        for(int[] trip: trips){
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            if(map.containsKey(from) == false){
                map.put(from, +people);
                stops.add(from);
            } else {
                map.put(from, map.get(from) + people);
            }
            
            if(map.containsKey(to) == false){
                map.put(to, -people);
                stops.add(to);
            } else {
                map.put(to, map.get(to) - people);
            }
        }
        
        Collections.sort(stops);
        int pic = 0;
        for(int stop: stops){
            // get people at particular stop
            int delta = map.get(stop); //1->2,3->5
            pic += delta; //add delta to pic 2+3=5
            
            if(pic > capacity){
                return false;//keep checking
            }
        }
        
        return true;
    }
}