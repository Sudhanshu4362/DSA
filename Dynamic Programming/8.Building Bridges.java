// Link -> https://www.geeksforgeeks.org/dynamic-programming-building-bridges/

//connect N and S such that no one cross each other after constructing max edges
/*
intituiton:what
bridges will not colide if north bank of a bridge is greater than second then its south bank also should be greater
for.e.g f ka north is greater thn f and south is also greater so they would not collide ,in case of f and c north
of c is greater then f but south of c is smaller 
*/


/* Approach:
1.Sort any bank and take lis on other bank i.e sort on north and take lis on south as we want to consider them in
increasing order of north bank -> b-f-d-c-e i.e sabse chota north bank wala pehle consider ho
2.South pe lis ->bad wale ka south pehle wale ke south se bda hi hoga north bde the south bhi bde mil gye return max
lis will give longest inc. seq.in which we decide is next number can be added to seq. or not and we add that no
only if it is greater then all tha no's.

  a  b  c  d  e  f  g  h
  8  1  4  3  5  2  6  7 -> cities on other bank of river
  1  2  3  4  5  6  7  8 -> cities on one bank of river

   1. a bridge start on 8 and connected to 1
   2. b bridge start on 1 and connected to 2
   3. c bridge start on 4 and connected to 3
   4. d bridge start on 3 and connected to 4
   5. e bridge start on 5 and connected to 5
   6. f bridge start on 2 and connected to 6
   7. g bridge start on 6 and connected to 7
   8. h bridge start on 7 and connected to 8

-> how many bridges we can construct b/w them
         b  f    d    c    e    g    h       a
  lis -> 1  2    2    2    3    4    5       0
bridges->b  bf   bd   bc   bce  bceg bcegh  X

At b-> b bridge bn jayega(base case)
at f-> we check if south bank of f > south bank  of b -> yes counstruct bf bridges
at d-> we check if south bank of d > south bank  of b -> yes , but south of f > south of d so f ke bad d not possible
at h->we check for all h wala bridges kab kab bna skte h in that after bceg constructed bcegh is valid
*/


class GFG
{
	static int maxNonOverlappingBridges(int[][] arr)
	{
        //sort -> 2d arr  brdg1 brdg 2
	    Arrays.sort(arr, (b1, b2) -> {
	        if(b1[0] != b2[0]){//north bank
	            return b1[0] - b2[0];
	        } else { //south bank-> if north bank pe equal h toh sort on south
	            return b1[1] - b2[1];
	        }
	    });
	    
	    int[] lis = new int[arr.length];
	    lis[0] = 1;
	    
	    for(int i = 1; i < arr.length; i++){
	        int max = 0;
	        for(int j = 0; j < i; j++){
                //check south banks for all j to i's
	            if(arr[j][1] <= arr[i][1]){
	                max = Math.max(max, lis[j]);
	            }
	        }
	        
	        lis[i] = max + 1;
	    }
	    
	    int len = 0;
	    for(int val: lis){
	        len = Math.max(len, val);
	    }
	    
	    return len;
	}
}