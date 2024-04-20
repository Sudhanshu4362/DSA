//print linewise means print node of same level at same line

/*Approach
1.Maintaine 2 queues q and childQ 
2.Remove from main queue and add child to ChildQ
3.after Main queue is empty update childQ to mainq and initialize a empty childQ

*/

// code:

class Solution {
    public static void levelOrderLineWise(Node root){
        Queue<Node> mQueue = new ArrayDeque<Node>();
        Queue<Node> cQueue = new ArrayDeque<Node>();
        mQueue.add(root);

        while(mQueue.size() > 0) {
            //r.p.a
            //remove
            Node temp = mQueue.remove();
            //print
            System.out.println(temp.data + "");
            //add child to the queue
            for(Node child : temp.children){
                cQueue.add(child);
            }
            // update the queues
            if(mQueue.size() == 0) {
                mQueue = cQueue;
                cQueue = new ArrayDeque<Node>();
                System.out.println();
            }
        }
        System.out.println();
    }   
    //using Linkedlist
    public static void levelOrderLineWiseLL(Node root){
        Linkedlist<Node> que = new LinkdedList<>();
        que.addLast(node);
        //first checking then decrement
        while(mQueue.size() != 0) {
            int currSize = que.size();
            while(currSize-- > 0){
                Node rnode = que.removeFirst();
                System.out.print(rnode + " ");
                
                for(Node child : rnode.childeren){
                    que.addLast(child);
                }
            }
        }
        System.out.println();
    }
}