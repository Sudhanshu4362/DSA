// find given node in Generic Tree

/* Approach : 
High level:
childo ko bolo vo apne tree me dhudhe
Low Level: 
draw eular tree
eular pura ni chlega bcz of return true in child call

*/
// code :
class Solution {
    public static boolean find(Node node,int data){

        if(node.data == data){
            return true;vdv
        }
        
        for(Node child : node.children){
            boolean fic = find(child,data);
            if(fic == true){
                return true;
            }
        }
        return false;
    }
}