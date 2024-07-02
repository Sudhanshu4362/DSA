//using recursion
class Solution{
    public static void preOrder(Node node){
        //Euler left se print i.e pehle print the calls (NLR)
        if(node == null) {return;}
        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void InOrder(Node node){
        //Euler mid se print i.e pehle left ki call then print then right calls (LNR)
        if(node == null) {return;}
        InOrder(node.left);
        System.out.println(node.data + " ");
        InOrder(node.right);

    }
    public static void PostOrder(Node node){
        //Euler right se print i.e pehle calls then prints (RLN)
        if(node == null) { return;}
        PostOrder(node.right);
        PostOrder(node.left);
        System.out.println(node.data + " ");
    }
}


//iterative
/* Approach :
1.if state is 1 -> pre,2 -> In,3 -> post
2. if you get state 1 at top of stack then state++, add in pre,Left child add || 2 -> state++,Im me add ,right child add || 3 -> post me add and Pop

*/
class Solution{
    static class TPair{
        Node node;
        int state;

        TPair(Node node,int state){
             this.node = node;
             this.state = state;
        }
    }
    public static void Iterative(Node node){
        Stack<TPair> st = new Stack<>();
        TPair rootP = new TPair(node,1);
        Stack.push(rootP);
        String pre = "";
        String in = "";
        String post = "";

        while(st.size() > 0){
            TPair top = st.pop();
            if(state == 1) {
                //pre
                pre += top.node.data + "";
                if(top.node.left != null){
                    Tpair leftp = new Tpair(top.node.left,1);
                    st.push(leftp)
                }

            //in
            } else if(top.state == 2){
                in += top.node.data + " ";
                if(top.node.right != null){
                    Tpair rightP = new Tpair(top.node.right,1);
                    st.push(rightP)
                }

            //post
            } else {
                post += top.node.data + " ";
                st.pop();
            }

            //state update
            top.state++;
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}