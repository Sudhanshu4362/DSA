// https://www.geeksforgeeks.org/remove-leaf-nodes-binary-search-tree/

//remove nodes in preorder if node ka left and right both null ho

// code :
class Solution {
    public Node removeLeaf(Node node){
        if(node == null) {
            return null;
        }

        if(node.left == null && node.right == null){
            return null; //after removing return null  to its parent node
        }

        node.left == removeLeaf(node.left);//receive in node ke left
        node.right == removeLeaf(node.right);//receive in node ke right

        return node;
    }
}