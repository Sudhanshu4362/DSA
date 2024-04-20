//return node to root path
/* Approach :
1.childo pe dhudhe and if ntcp me kuch h toh add that node also in node to root path
2.add actual node in base case  
 */
// code:

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
}