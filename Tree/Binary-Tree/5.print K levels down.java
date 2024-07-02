//k level neeche jake print the nodes at that level

/* Approach: 
1.make calls for left and right childs with one step down from  k i.e k-1
2. k == 0 is level we want to print so print node value and return from there so that do not check lower levels from k
*/


// code
class Solution{
    public void pkDown(Node node,int k){
        if(node == null || k < 0){
            return;
        }
        if(k == 0){
            System.out.println(node.left,k-1);
            return;
        }

        pkDown(node.left,k-1);
        pkDown(node.right,k-1);
    }
}