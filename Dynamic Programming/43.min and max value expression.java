// https://www.geeksforgeeks.org/minimum-maximum-values-expression/
// MCM group
/* Approach:
intuition -> we will try to divide on operators
Approach :- SAME AS MCM
 
 expr: 1+2*3+4*5 => operends = [1,2,3,4,5]
                    operators = [+,*,+,*]

          a            /ans
  1+(2*3)/7    (1+2)*3/9
          \   /
        1 + 2 * 3

          1   +    2   *    3   +    4   *    5 

     1    1-1      12-3    123-9   1234-21  12345-105
  +
     2    X        2-2     23-6     234-14   2345-70
  *
     3    X         X       3-3     34-7     345-35
  + 
     4    X         X       X      4-4        45-20
  *
     5    X         X       X        X        5-5

     for g = 0 -> ans is same that operand i.e 1-1,2-2,3-3
     for g = 1 -> ans is solution of that expression
     for g > 1 -> 1+2*3 ko solve krne ka 2 tarike h 1+(2*3) and (1+2)*3 same row ka pehla(i.e 1) and col ka next(23) total ops = 1+23 and for next variation row++,col++ i.e 12 and 3 ko leke take min of all
*/