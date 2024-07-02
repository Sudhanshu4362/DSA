// cal sum,max,min,height of a GT

/*Approach : 
1.create variables in heap bcz stack me variable ud jate h 
2.calculate values in preporder and call in postorder
*/

class Solution {
    static int sum = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int ht = -1
    public static void multisolver(Node node,int depth){
        sum += node.data;
        max = Math.max(node.data,max);
        min = Math.min(node.data,min);
        ht = Math.max(depth,height);
        for(Node child : node.children){
            multisolver(child,depth + 1)
        }
    }
}