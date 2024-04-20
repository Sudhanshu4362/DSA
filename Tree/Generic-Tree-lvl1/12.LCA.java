// Node 1 and Node 2 ke Ntrp me jo bnda last common hota h vo lca hota h
// for e.g Ntrp1 => 120,80,30,10
        //    Ntrp2 =>  90,30,10  => 30 is lowest common ancesstor


/* Approach:
1.get node to root path for both nodes
2.reversely loop through these Arraylist 
3.if nodes are same and stop at first mismatch 
4.go back one step anmd
 */

// code :
class Solution {
    public static boolean ntrp(Node node,int data){
        if(node.data == data){
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.data);
            return bres;
        }
        for(node Child : node.children){
            ArrayList<Integer> ntcp = ntrp(child.data);
            if(ntcp.size() > 0){
                ntcp.add(node.data);
                return ntcp
            }
        }
        return new ArrayList<>();
    }
    public static int lca(Node node,int d1,int d2){
        ArrayList<Integer> p1 = ntrp(node,d1);
        ArrayList<Integer> p2 = ntrp(node,d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while(i >= 0 && j >= 0){
            if(p1.get(i) == p2.get(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        int lcap = p1.get(i + 1);
        return lcap;
    }
}
