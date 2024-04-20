//Generic Tree => any node have any number of childeren
           pc=>root
       /   |   \
 movies  music    tax(parent)
 /    \    /   \     /  \
hindi eng hindi eng 1819 1920(childeren)


/* Construction

       10
     /  |  \ 
    20  30   40
   / \  /  \
 50  60 70  80 

*/


// code:
class Main{
    pulic static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args){
        Node root = new Node(10);

        Node 2nd = new Node(20);
        root.childeren.add(2nd);

        Node 3rd = new Node(30);
        root.childeren.add(3rd);

        Node 4th = new Node(40);
        root.childeren.add(4th);

        Node 5th = new Node(50);
        2nd.childeren.add(5th);

        Node 6th = new Node(60);
        2nd.childeren.add(6th);

        Node 7th = new Node(70);
        3rd.childeren.add(7th);

    }
}