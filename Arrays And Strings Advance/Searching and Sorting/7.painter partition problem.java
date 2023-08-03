// Link -> https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1

/* given n boards with length as arr[i] and no of Painters as k calculate min time
/*

/* Approach :
1.get lta as max
2.hta as sum of all elements
3.calculate mid 
4.painters req and curr painter work to check how many painters needed according to this time allowed(mid)
5.loop on array and calculate currpwork if it exceeds ta inc the count of painters
6.if count of painters k se jyada h means right side me answer h else left side me

arr ->  {5,10,30,20,15} , n = 5 , k = 3
min time -> max i.e 30
max time -> if ek hi painter hota toh sum of all jitna time lgta i.e 60
*/
class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        long lta = Long.MIN_VALUE; //lowest time allowed -> if k painters hte hr painter 1 krta toh lta me max aaega
        long hta = 0; //highest time allowed -> 1 hi painter sara kam kre
        for(int val : arr) {
            hta += val;
            lta = Math.max(lta,val);
        }
        
        while(lta < hta){
            long ta = (lta + hta) / 2;
            int pntreq = 1; //painter req
            int currpwork = 0; //curr painter work
            for(int val : arr){
                if(currpwork + val <= ta){
                    currpwork += val;
                } else {
                    currpwork = val;
                    pntreq++;
                }
            }
            if(pntreq > k){
                //painter req exceed given painters -> kam time used move to larger time
                lta = ta + 1;
            } else {
                hta = ta;
            }
        }
        return lta;
    }
}