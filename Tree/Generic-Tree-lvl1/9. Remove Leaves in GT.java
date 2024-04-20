// Remove all leaf nodes from a Generic Tree or N-ary Tree

/* Approch :
if post order me removal krege toh post me sare nodes ud jayege except 10 : dry run [post order me jo leaf nhi hua krte the vo bhi leaf honge after removing childs toh vo bhi remove ho jayege]
HIGH ORDER THINKING : request all child nodes to remove leaf nodes recursively
LOW ORDER THINKING : 
1.loop in reverse to all the child nodes and check if size of child.children is zero if yes then remove that node
WHY LOOP IN REVERSE : arraylist se removal ke liye loop ulta chalana hota h.
if not in rev => remove all odds from AL
5 9 14 16 18 17 33
after removing 5 idx will changed now 0 pe 9 h and after i++ you will at 14 and 9 rh jayega
if loop in reverse
33 removed and i-- se  idx wont changed bcz peeche se remove ho rhe
*/

// Code:
class Solution {
    public static void removeLeaf(Node node) {
        for(int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if(child.children.size() == 0) {
                node.children.remove();
            }
        }

        //request the child nodes
        for(Node child : node.children) {
            removeLeaf(child);
        }
    }
}