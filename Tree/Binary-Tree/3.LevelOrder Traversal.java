// traverse the Binary Tree in levels
//Link -> https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

/* Approach :
1.create a queue and add root to it
2.loop till  queue is not empty 
3.get size and create another list for add nodes at level
4.loop the queue and remove the node and add removed node to list and make calls for left and right childs and add child to the queue
5.after loop add the level list to ans list and return it
*/


//code:
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if (node.left != null) {
                    queue.add(node.left);
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(level);
        }
        
        return ans;
    }
}

//using two Queues
class Solution {
 public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> cqueue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                
                if (node.left != null) {
                    cqueue.add(node.left);
                }
                
                if (node.right != null) {
                    cqueue.add(node.right);
                }
                if(queue.size() == 0){
                    queue = cqueue;
                    cqueue = new ArrayDeque<>();
                }
            }
            ans.add(level);
        }
        
        return ans;
    }
}
