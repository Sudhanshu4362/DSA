//  Link -> https://www.geeksforgeeks.org/problems/power-of-numbers-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//p(2,5) => 2.2.2.2.2 = 32

/*Approach :
1.Exp -> p(2,5) = 2.2.2.2.2 = 32
2.faith -> p(2,4) = 2.2.2.2 = 16
3.EWF -> 2.p(2,4) = 32

*/

// code :
//Linaer Approch:
class Solution
{
        
    long power(int x,int n)
    {
        
        if(n == 0){
            return 1;
        }
        //Your code here
        long xpnm1 = power(x,n-1);
        long xpn = xpnm1 * x;
        
        return xpn;
        
    }

}

//Logarithmic approach:
class Solution
{
     
    long power(int x,int n)
    { 
        long MOD = 1000000007;
        
        if(n == 0){
            return 1;
        }
        //Your code here
        long xpbn2 = power(x,n/2);
        long xpn = (xpbn2 * xpbn2)%MOD;
        
        if(n % 2 == 1){
            xpn = (xpn * x)%MOD;
        }
        
        return xpn;
        
    }

}-*--------------------------------------------------------