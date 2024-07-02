//size = ls + rs + 1
//sum = lsum + rsum + node.data
//max = max(lmax,rmax,node.data)
//ht = max(lh,rh) + 1

class Solution{
    public static int size(Node node){
        if(node == null){ 
            return 0;
        }
        int lsize = size(node.left);
        int rsize = size(node.right);
        return lsize + rsize + 1;

        //one line code for above
        return (node == null ? 0 : size(node.left) + size(node.right) + 1);
    }
    public static int sum(Node node){
        if(node == null){ 
            return 0;
        }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return lsum + rsum + node.data;
    }
    public static int max(Node node){
        if(node == null){ 
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);
        return Math.max(node.data,lmax,rmax);
    }
    public static int height(Node node){
        if(node == null){ 
            return 1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh) + 1;
    }
}