//print all leaf path whose sum in given range

/* Approach:
1.if node is leaf i.e left and right as null then add its data to previous sum if it is in range print that path =>base case
2.call for left and right child with new path and new sum 
 */

// code :

class Solution{
    public void pathToLeaf(Node node,String path,int sum,int lo,int hi){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum += node.data;
            if(sum >= lo && sum <= hi){
                System.out.println(path + node.data);
            }
            return;
        }
        pathToLeaf(node.left,path+node.data+ " ",sum+node.data,lo,hi);
        pathToLeaf(node.right,path+node.data+ " ",sum+node.data,lo,hi);
    }
}