// symmetric things are mirror image of themselves


// code :

class Solution {
    public boolean areMirror(Node n1,Node n2) {
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i = 0;i < n1.children.size();i--){
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(n2.children.size() - 1 - i); //check reversely for second tree for mirror image //left right and right left hota h mirror image me

            if(areMirror(c1,c2) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean IsSymmetric(Node node){
        return areMirror(node,node);
    }
}