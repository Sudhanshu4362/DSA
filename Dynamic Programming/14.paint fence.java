// https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
// you are given n fences and k colors ,return no of ways s.t fence could be painted so that more not more then 2 
// consecutive fences have same color

/* Approach:
1.fore same 2 colors we will add repeated colors for different colors(ij) i.e r->rr,g->gg,b->bb
2.for different colors ans will total * (k-1) pehle pe jo lgaya h usse different ke liye k - 1
 for 3 colors:
               1           2               3               4   
 same(ii) ->   -         [rr,gg,bb]-3       6             18
 diff(ij) ->   3[r,g,b]  [rg,gr,br,rb,     9(k-1) = 18    34 X 2 = 48
                           bg,gb] -> 6
 total ---->   3             9                24           66

               
 for n = 2 -> 3 * 2 = 6 i.e  r -g,b lag skta h
                             g -r,b
                             b -r,g 
*/     


class Solution
{
    int MOD = 1000000007;
    long countWays(int n,int k)
    {
        long ii = (k * 1) % MOD;
        long ij = (k * (k - 1)) % MOD;
        long tot = (ii + ij) % MOD;
        
        for(int i = 3; i <= n; i++){
            ii = (ij * 1) % MOD;
            ij = (tot * (k - 1)) % MOD;
            tot = (ii + ij) % MOD;
        }
        return tot;
    }
}
