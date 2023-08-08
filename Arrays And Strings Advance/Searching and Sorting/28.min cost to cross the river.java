// 
/*
N people needs to cross the river but only one boat is present on wich max 2 person can board each person pays specific
price i.e p[i] if two people travels then price is max of the two cost boarded the boat
find the min cost
*/
 
/* Approach:
1.sort the prices
2.for only one person return price[0]
3.for 2 return price[1]
4.for 3 return sum of price[0] + price[1] + price[2]
5.for 4 or greater calculate f1 as sum of larget 2 + twice of smallest i.e f + e + 2a
f2 as sum of lagest + smallest + second smallest i.e f + a + 2b 
return min of these two

prices -> 30,40,60,70
                30,70->70
    30,40,60,70 -------> 70
                30 -> 30
    30,40,60<------------ 70
            30,60->60
    30,40,60 -------> 60,70
                30 -> 30
    30,40<------------ 70
          30,40->40
    30,40 -------> 30,40,60,70
      cost -> 70 + 30 + 60 + 30 + 40 = 230 -> but it can be done in 220 

how can be it done in 220 ->
  person ------> ans
        a->a
    a ---------->a  -> 1 person case
        a,b -> b
    a,b---------->b  -> 2 person case
       
    a,b,c---------->a + b + c  -> 3 person case (a+b+c cost lagni hi h)

    for 4 or greater no of persons
    -------------------------------
    a,b,c,d,e,f ----->
    1st way -->send max with min for this as we have done in 230 case ans will be e + f + 2a
    2nd way --> agar 2b > e + a in this case 
                    
                    a,b-b
        a,b,c,d,e,f ----->b
                      a
        a,c,d,e,f <-----b
                    e,f-f
        a,c,d,e,f ----->b,e,f
                   b-b
        a,b,c,d <-----e,f

       f + a + 2b -> in this case if 2b> e+a then it canbe answer

*/

class GFG
{
	static long minimumCost(long price[], int n)
	{
        Arrays.sort(price);
        
        if(n == 1){
            return price[0];
        }
        
        long ans = 0;
        for(int i = n - 1; i >= 1; i -= 2){
            if(i == 1){
                //if 2 hi person h
                ans += price[1];
            } else if(i == 2){
                //for 3 persons
                ans += price[0] + price[1] + price[2];
            } else {
                long f1 = price[0] + price[i] + price[0] + price[i - 1];//f+a+e+a
                long f2 = price[1] + price[0] + price[i] + price[1];//f+a+b+b
                ans += Math.min(f1, f2);//return min
            }
        }
        
        return ans;
	}
}