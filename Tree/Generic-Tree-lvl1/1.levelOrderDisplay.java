//display of GT in levelorder

//Link =>  https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/

/* Approach : remove -> print -> add child
1.create a empty queue of nodes and add root to it
2.now loop till queue is not empty and first remove from the queue and print the data and loop the child of that node and add childeren to the queue.
*/

// code
class Solution {
    public static void levelOrder(Node root){
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while(queue.size() > 0) {
            //r.p.a
            //remove
            Node temp = queue.remove();
            //print
            System.out.println(temp.data + "");
            //add child to the queue
            for(Node child : temp.children){
                queue.add(child);
            }
        }
        System.out.println();
    }   
}

// LeetCode Solution
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return ans;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for(int i = 0;i < n;i++){
                Node curr = q.remove();
                temp.add(curr.val);
                for(Node child : curr.children){
                    q.add(child);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}