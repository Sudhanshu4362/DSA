//Pre and Post order
/*Node ke left => node ka pre
Edge ke left => Edge ka pre
Node ka right => Node ka post
Edge ka right => Edge ka post
*/ 

class Solution{
    public static void traversals{
        //node pre
        System.out.println("Node pre " + node.data);
        //loop,before call is edge pre,after call is edge post
        for(Node child : node.children){
            System.out.println("Edge pre " + node.data + "--" + child.data);
            //call
            traversals(child);
            System.out.println("Edge post " + node.data + "--" + child.data);
        }
        //node post
        System.out.println("Node post " + node.data);
    }
    
}
