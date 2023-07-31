// link -> https://leetcode.com/problems/gas-station/

/* There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i]
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station 
to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
*/

/* Approach:
1.Take currsum and calculate delta as gas[i] -cost[i] and add it to currsum
2.if currsum is negative it means you can not start your journey from here so move start to next point
3.take overall sum if it is greater then zero to ans possible h

4,2 ke bad ham sidha 2,1 se journey start krke dekhege bcz if 4,2 se journey possible nhi h to 5,4 and 3,7
se bhi possible nhi hogi bcz csum aur negative ho jayega bcz prev sum add nhi ho rha hoga
6,2 se answer aayega and poora chalane ki jrurat nhi h bcz overall sum +ve h jo last me +ve leke jayega vo
puri journey krayega hi
(gas,cost) -> (4,2)  (5,4)  (3,7)  (2,1)  (5,3)  (3,1)  (3,9) (6,2)  (2,4)
csum->     0----2-------3---- -1
                               0------1-------3-----5---- -1
                                                           0------4-----2---
            <..............................................................|
            -----4-------5------1------2------4------6------0------> so form 6,2 journey is possible
*/

// code:
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int csum = 0;
        int osum = 0;
        int si = 0;
        for(int i = 0;i < gas.length;i++) {
            int delta = gas[i] - cost[i];
            osum += delta;
            csum += delta;
            if(csum < 0) {
                //move start point for negative sum
                csum = 0;
                si = i+1;
            }
        }
        if(osum >= 0) {
            return si;
        } else {
            return -1;
        }
    }
}