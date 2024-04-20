//given two nodes find the number of edges or node b/w them 
// Based on NTRP

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
    public static int Distance(Node node,int d1,int d2){
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
        i = i + 1;
        j = J + 1;

        return i + j;
    }
}
