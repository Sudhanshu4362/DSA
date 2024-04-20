// print in Zigzag format i.e ->,<-,-> for.e.g 10,40,30,20,50,60,70,80

//HINT: ODD-EVEN LEVEL

/*Approach:
1.Maintain one stack and one queue and add root to queue
2.loop till que.size is greater then 0 and get current size
3.if you are on even level of tree then implement incresing loop to add childeren else decrement loop for odd level 
4.then increase the level count and update the stack and queue
*/

// code:

class Solution {
    public static void levelOrderLineWise(Node root){
        LinkedList<Node> que = new LinkedList<Node>();//FIFO
        LinkedList<Node> st = new LinkedList<Node>();//LIFO
        que.add(root);
        int level = 0;
        while(que.size() > 0) {
            int currSize = que.size();
            while(currSize-- > 0){
                Node rnode = que.removeFirst();
                System.out.println(rnode.data + "")
                if(level % 2 == 0){
                    for(int i = 0;i < rnode.children.size();i++){
                        st.addFirst(rnode.children.get(i))
                    }
                } else {
                    for(int i = rnode.children.size()-1;i >= 0 ;i--){
                        st.addFirst(rnode.children.get(i))
                    }
                }
                level++;
                System.out.println();
                LinkedList<Node> temp = que;
                que = st;
                st = temp;
            }
        }
    }   
}