//find node and return path to it

/* Approach :
FIND =>
-------
1.call for left child with data if find true in left return true
2.call for right child with data if find true in right return true
3.base case => if node ka data is equal to data then return true

NTRP :
-------
1.call for left child with data if list have something in it means node had been found and add that node to leftlist
2.call for right child with data if flist have something in it means node had been found and add that node to rightlist
3.base case => if node ka data is equal to data then create a list and add that node to that list

*/

//code :
class Solution{
    boolean find(Node node,int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            return true;
        }

        int fil = find(node.left,data);
        if(fil == true){
            return true;
        }

        int ril = find(node.right,data)
        if(ril == true){
            return true;
        }

        return false;
    }
    
    //root to node path
    ArrayList<Integer> ntrp(Node node,int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        ArrayList<Integer> llist = ntrp(node.left,data);
        if(llist.size() > 0){
            llist.add(node.data);
            return llist;
        }
        ArrayList<Integer> rlist = ntrp(node.right,data);
        if(rlist.size() > 0){
            rlist.add(node.data);
            return rlist;
        }

        return new ArrayList<>();
    }
}