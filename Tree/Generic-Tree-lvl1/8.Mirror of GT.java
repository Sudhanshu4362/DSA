// Given a Tree where every node contains variable number of children, convert the tree to its mirror

/* 
1.have faith ki child mirror ho jayege

*/
// code

class Solution{
    public void mirror(Node node){
        for(Node child : node.childeren){
            mirror(child);
        }
        //reverse the all child of nodes
        Collections.reverse(node.childeren)
    }
}
