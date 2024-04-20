//construct tree from given input
// input  -> [10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1]

// -1 for traversal in right side of a node i.e already traversed
/* Approach:
1.Maintain a stack of nodes
2.loop through the array and if val is not -1 then add create a new node with that val and add it to the stack
3.if it is -1 then pop the top of the stack and check if stack is empty if not then poped element will be child of node at top of stack and add that node to parent node as child node else you are at root node
*/

// Code
class solution {
    public static Node construct(int[] arr){ 
        Node root = null;
        Stack<Node> st = new Stack<>();

        for(int val : arr){
            if(val != -1) {
                Node node =new Node(val);
                st.push(node);
            } else {
                Node node = st.pop();
                if(st.size() > 0){
                    Node parennt = st.peek();
                    parent.children.add(node);
                } else {
                    root = node;
                }
            }
        }
        return root;
    }
}