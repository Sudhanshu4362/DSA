//Size = > total count of nodes in GT
/* Approach
1.get size of each childeren through recursion and add it to size

MAXIMUM:
1.ask each child nodes of root to get max of each child and update maxchild if you found max.

HEIGHT:
1.height is similar to max but we return height + 1 as we will also add to root node.`

*/


class Solution{

    public static int size(Node node){
        int size = 0;
        for(Node child : node.childeren){
            size += size(child);
        }
        return size + 1;
    }
    public static int max(Node node){
        int max = 0;
        for(Node child : node.childeren){
           int recAns = max(child);
           max = Math.max(max, recAns);
        }
        return max;
    }
    public static int height(Node node){
        int ht = -1;
        for(Node child : node.childeren){
            int recAns = height(child);
            ht = Math.max(max, recAns);
        }
        return ht + 1;
    }
}