//check if two tree are mirror image of eachother or not

//same as areSimilar only difference is that we have to check one child from start and for second tree get child from last

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
}