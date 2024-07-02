//Given a binary tree, the task is to print all the nodes having exactly one child. Print “-1” if no such node exists.

class Solution{
    public void printSingleChild(Node node,Node parent){
        if(node == null){
            return;
        }

        if(parent != null && parent.left == null && parent.right == node){
            //check for right single child
            System.out.print(node.data);
        } else if(parent != null && parent.right == null && parent.left == node) {
            //left single child
            System.out.print(node.data);
        }

        printSingleChild(node.left,node);
        printSingleChild(node.right,node);
    }
}