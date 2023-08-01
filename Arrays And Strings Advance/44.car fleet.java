// link -> https://leetcode.com/problems/car-fleet/
// n no of cars going in same direction towards a destination a car never pass a car ahead of it instead they 
// they combine and move with smaller velocity of two return how many combination of such car to reach the dest.

/* Approach:
1.Maintain a HashMap of group of position against speed
2.now get every set from last and get pos and speed and calulate distance as target - pos and time required to 
reach the destination by dividing dist to time.
3.if same time means same fleet but if curr time is greater then prev. time then it will not come with prev. fleet 
if time is smaller it cant pass car ahead of it so we do not need new group in that case
           i  i  i  i
road->  0  3  5  8  10  12<-dest
speed-> 1  3  1  4  2
at 6 3,5 combine together and at 12 8,10 combine and reach together 0 will reach individually
time -> group
1 -> 8,10
7 -> 3,5
12 -> 0

*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0;i <position.length;i++) {
            //map of position vs speed
            map.put(position[i],speed[i]);
        }
        double time = 0;
        int groups = 0;
        //last wala pehle milega i.e from last
        for(Map.Entry<Integer,Integer> car : map.entrySet()) {
            int pos = car.getKey();
            int spd = car.getValue();

            int dist = target - pos;
            double ctime = dist * 1.0/ spd;
            // agar current time is greater then previous time then we need a new group 
            if(ctime > time) {
                time = ctime;
                groups++;
            }
        }
        return groups;
    }
}

// M-2
class Solution {
    class Car implements Comparable<Car> {
        int pos;
        int speed;
        
        Car(int pos, int speed){
            this.pos = pos;
            this.speed = speed;
        }
        
        public int compareTo(Car c){
            return this.pos - c.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i = 0; i < position.length; i++){
            cars[i] = new Car(position[i], speed[i]);
        }
        
        Arrays.sort(cars);
        
        int groups = 0;
        double time = 0;
        for(int i = cars.length - 1; i >= 0; i--){
            Car c = cars[i];
            double ctime = (target - c.pos) * 1.0 / c.speed;
            if(ctime > time){
                time = ctime;
                groups++;
            }
        }
        
        return groups;
    }
}