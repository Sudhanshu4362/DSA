// given an Integer arr construct a BT using that arr and then display the BT

// arr[] = [50,25,12,n,n,37,30,n,n,n,75,62,n,70,n,n,87,n,n]
/* Approach :
1.created root with arr[0] and rootPair with this root and push it in stack.
2.loop till stack have something get pair at top and if state of that pair is 1 i.e it is left child create left child with that node if arr[idx] is not null and add it to the left of top node at stack and create left pair add it to stack and inc the state and idx 
3.do same for right if state is 2 and if state is 3 it means pop that element

*/

// code  

class Solution {
    public static class Node{
        int data;
        int left;
        int right;
    }

    Node(int data, Node left,Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    static clas Pair{
        Node node;
        int state;//1->left,2->right,3->pop
    }

    Pair(Node node,int state){
        this.node = node;
        this.state = state;
    }

    public static Node construct(Integer[] arr){
        Stack<Pair> stack = new Stack<>();
        //root
        Node root = new Node();
        root.data = arr[0];

        //rootPair 
        Pair rootP = new Pair(root,1);

        stack.push(rootP);
        int idx = 1;

        while(stack.size() > 0){
            Pair peekP = stack.peek();
            if(peekP.state == 1){
                //left
                if(arr[idx] != null){
                    Node lc = new Node();
                    lc.data = arr[idx];
                    peekP.node.left = lc;

                    Pair lp = new Pair(lc,1);
                    stack.push(lp);
                }
                peekP.state++;
                idx++;
            } else if(peekP.state == 2){
                //right
                if(arr[idx] != null){
                    Node rc = new Node();
                    rc.data = arr[idx];
                    peekP.node.left = rc;

                    Pair rp = new Pair(rc,1);
                    stack.push(rp);
                }
                peekP.state++;
                idx++;
            } else if(peekP.state == 3) {
                //pop
                stack.pop();
            }
        }
        return root;
    }

    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = "<-" + node.data + "->";
        String lstr = node.left != null ? "." : node.left.data + ".";
        String rstr = node.right != null ? "." : node.right.data + ".";
        System.out.println(lstr + str + rstr);

        display(node.left);
        display(node.right);
    }
}