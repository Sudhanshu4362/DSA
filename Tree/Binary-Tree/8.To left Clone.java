//har ek node ke left me usi ki copy lga do

/* Approach :
1. left and right child ko bolo vo clone ho jaye => faith
1.create a new node with node.data and left and right as null
 */

// code
class Solution{
    public static Node clone(Node node){
        if(node == null) {
            return null;
        }
        Node left = clone(node.left);
        Node right = clone(node.right);

        Node newNode = New Node(node.data,left,null);//jo left recursion call se aaya
        node.left = newNode;//old node ke left ko new node child
        return node;
    }
}

//from clone to normal
// extra left node hatana h 

class Solution{
    public static Node transformBack(Node node){
        if(node == null) {
            return null;
        }
        Node left = transformBack(node.left.left);
        Node right = transformBack(node.right);

        node.left = left//set left to left return from recursion call escaping cloned node 
        return node;
    }
}
