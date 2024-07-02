// each node have same number of childs => values diff but shape same

/* Approach : 
1.ask childes if they have same number of childeren with corresponding tree 
2.in base case check if n1 child ki size is equal with n2 ke child
*/
// code

class Solution {
    public boolean areSimilar(Node n1,Node n2) {
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i = 0;i < n1.children.size();i--){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(i);

            if(areSimilar(c1,c2) == false){
                return false;
            }
        }
        return true;
    }
}