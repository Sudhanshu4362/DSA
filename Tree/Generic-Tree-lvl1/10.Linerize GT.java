// Linearize a Gt to ArrayList like structure.


/* Approch : 
HOT:
root ke child ko recursively linearize kr diya..
LOT:
1.loop till node have only one child 
2.remove last node of that node
3.and get second last node as it will now be last node as we have removed previous last node 
4.find tail of slast node and add last ko add kr do second last ki children me
*/
// Code:
class Solution {
    public static void Linearize(Node node) {
        //faith se child linarize
        for(Node child : node.children){
            Linearize(child);
        }

        //postorder me 
        while(node.children.size() > 1) {
            //last node 
            Node last = node.children.remove(node.children.size() -1);
            //slast ,nya last after removing 
            Node slast = node.children.remove(node.children.size() -1);
            Node slasttail = getTail(slast);
            slasttail.children.add(last);
        }
    }
    public static Node getTail(Node node) {
        while(node.children.size() > 0) {
            //jab tak size 0 nhi ho jata to get tail
            node = node.children.get(0);
        }
        return node;
    }
}

//efficient linearize in O(n)
/* 1. last ko remove krke linearize kr diya and second last linearize kiya tab uski tail bhi mil gyi and second last ki tail me last ko add kr  diya 
*/

class Solution {
    public static Node Linearize(Node node) {
        if(node.children.size() == 0){
            return node;
        }
        
        //last ki linearization
        Node lastchild = node.children.get(node.children.size() - 1);
        Node lstkitail = linearize(lastchild);

        //slast
        while(node.children() > 1) {
            Node slastChild = node.children.get(node.children.size() - 2);
            Node slasttail = linarize(slastChild);
            slasttail.children.add(lastChild);
            node.children.remove(node.children.size() -1);
            //updating lastchild as slast
            lastchild = slastChild;
        }
        return lstkitail;
    }
}
