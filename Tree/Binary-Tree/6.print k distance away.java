//hint : uses Node2rootPath and k level down nodes

// given a node  you have to print all nodes k level away from that node

/* Approach :
1.first get Node2RootPath 
n2rp => 50,e,b,a,h
50 se 4  ,e se 3 , b se 2, a se 1, h se o dur wale print kr do but sare ni you need to have a blocker for all but not needed for 50
e ke liye 50 is blocker as we dont want to print 50 ke side wale 
b ke liye e is blocker , a ke liye b is blocker , h ke liye a is blocker
*/

// CODE :
class Solution{
    public static void KlevelDown(Node node,int k,Node blocker){
        if(node==null || k<0 || node==blocker)
        {
           return;
        }

        if(k==0)
        {
           System.out.println(node.data);
        }

        printKLevelsDown(node.left,k-1,blocker);
        printKLevelsDown(node.right,k-1,blocker);
    }  
    ArrayList<Node> ntrp(Node node,int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        ArrayList<Node> llist = ntrp(node.left,data);
        if(llist.size() > 0){
            llist.add(node);
            return llist;
        }
        ArrayList<Integer> rlist = ntrp(node.right,data);
        if(rlist.size() > 0){
            rlist.add(node);
            return rlist;
        }

        return new ArrayList<>();
    }
    public static void kNodeFar(Node node, int data,int k){
        ArrayList<Node> n2rp = ntrp(node,data);
        for(int i = 0;i < n2rp.size();i++){
            printKLevelsDown(n2rp.get(i),k-i,i>0?n2rp.get(i+1):null)
        }
    }
}

//blocker => i>0?n2rp.get(i+1):null