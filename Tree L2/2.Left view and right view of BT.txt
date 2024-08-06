// link :- https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
// Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. 
//hint => Reverse Level Order => after removing from queue add only first node 

/*Approach :
1.create a queue and add root to the queue
2.till queue is not empty ,loop till queue.size and get first node at each level and add it to the list 
*/

// Code :
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> list = new ArrayList<>();
      if(root == null) {
        return list;
      }

      Queue<Integer> queue = new LinkedList<>();
      queue.add(root);
      while(queue.size() > 0) {
        int lsize = queue.size();
        for(int i = 0;i < lsize;i++){
            Node temp = queue.remove();
            if(i == 0) {
                list.add(temp.data);
            }

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
      }
      return list;
    }
}

//right view
// Leetcode link  :https://leetcode.com/problems/binary-tree-right-side-view/description/
//change 
// instead of adding first node removed from queue we add last node to list 


//code :
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
     ArrayList<Integer> list = new ArrayList<>();
      if(root == null) {
          return list;
      }
      Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       while(q.size() > 0) {
           int lsize = q.size();
           for(int i = 0;i < lsize;i++){
               TreeNode temp = q.remove();

               //change from Left view
               if(i == lsize - 1) {
                   list.add(temp.val);
               }
               if(temp.left != null) {
                   q.add(temp.left);
               }
               if(temp.right != null) {
                   q.add(temp.right);
               }
           }
       }
       return list;
    }
}

