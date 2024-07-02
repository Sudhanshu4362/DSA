//leetcode link :https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
// gfg link : https://www.geeksforgeeks.org/problems/reverse-level-order-traversal/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article


/*problem statement
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root). 
*/

/* Approach : 
queue => level order, stack => reverse
1.Create a queue of nodes add root to the queue.
2.create a stack of list (of each level) .
3.till queue has something , create a list for level and loop till queue size remove node and add left and right child to queue and add node val to list and add this list to stack and start removing from stack and add to the res list.
*/




//leetcode solution : 
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       List<List<Integer>> res = new LinkedList<>();
       if(root == null) {
           return res;
       }
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       Stack<List<Integer>>st = new Stack<>();
       while(queue.size() > 0) {
           int size = queue.size();
           List<Integer> list = new LinkedList<>();
           for(int i = 0;i < size;i++) {
               TreeNode node = queue.remove();
               if(node.left != null) {
                   queue.add(node.left);
               }
               if(node.right != null) {
                   queue.add(node.right);
               }
               list.add(node.val);
           }
           st.push(list);
       }
       while(st.size() > 0) {
           res.add(st.pop());
       }
       return res;
    }
}


//gfg code : 
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        while(queue.size() > 0) {
            Node temp = queue.remove();
            st.push(temp.data);
            if(temp.right != null){
                queue.add(temp.right);
            }
            if(temp.left != null){
                queue.add(temp.left);
            }
        }
        while(st.size() > 0) {
            int val = st.pop();
            res.add(val);
        }
        return res;
    }
}      