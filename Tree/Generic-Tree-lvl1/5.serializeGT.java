//form the array from Given tree

/*Approach:
1. add the root and loop the childeren add recursively to the list
*/

// Code

class solution {
    public static Node serialize(Node root,Arraylist<Integer> list){ 
        list.add(root.data);
        for(Node child : root.children){
            serialize(child,list);
        }
        list.add(-1);
    }
}