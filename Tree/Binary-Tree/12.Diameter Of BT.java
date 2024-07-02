// Diameter of Binary tree is length of longest path b/w any two nodes in tree.



//leetcode soluion
class Solution {
    private int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        calculateDia(root);
        return dia;
    }
    private int calculateDia(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = calculateDia(root.left);
        int rh = calculateDia(root.right);
        dia = Math.max(dia,lh + rh);
        return 1 + Math.max(lh,rh);
    }

}