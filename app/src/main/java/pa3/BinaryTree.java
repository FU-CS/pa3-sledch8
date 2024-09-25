package pa3;

/**
 * A binary tree class that stores integers.
 * 
 * The integers are stored in the tree in the order they are added.
 * 
 * The integers are stored from top to bottom by level i.e. node is added to a new level only when the current level is full.
 * Within each level, the integers are stored from left to right.
 * In other words, the tree is always Balanced: depth of the left and right subtrees of every node differ by at most 1.
 * 
 */
public class BinaryTree {

    private Node root;

    /**
     * Constructs an empty binary tree.
     */
    public BinaryTree() {
        this.root = null;
        
    }

    /**
     * Returns the level order traversal of the tree.
     * 
     * The level order traversal of a tree is the traversal of the tree by levels.
     * 
     * USE THE QUEUE from the pa3 package to implement this method. 
     * You are not allowed to use the built-in Java Queue.
     * 
     * Use the private helper method levelOrderTraversalHelper to implement this method.
     * 
     * @return the level order traversal of the tree.
     */
    public String levelOrderTraversal() {
        String newstring = levelOrderTraversalHelper(this.root, "");
        return newstring;
        
    }

    /** 
     * Helper method for levelOrderTraversal that takes a node as an argument.
     */
    private String levelOrderTraversalHelper(Node node, String result) {
        if (node == null){
            return "";
        }
        Queue treequeue = new Queue();
        treequeue.enqueue(node);
        while (treequeue.isEmpty() == false){

            Node curr = treequeue.dequeue();
            result += curr.value + " ";

            if (curr.left != null){
                treequeue.enqueue(curr.left);
            }

            if (curr.right != null){
                treequeue.enqueue(curr.right);
            }
        }
        return result;
    }

    /**
     * Adds a value to the tree.
     * 
     * The value is added to the tree in the order it is added.
     * Use a variant of the level order traversal to add the value to the tree.
     * First time you find a null child, add the new node there.
     * 
     * @param value the value to add to the tree.
     */
    public void add(int value) {
        Queue treequeue = new Queue();
        Node newnode = new Node(value);
        if (this.root == null){
            this.root = newnode;
            return;
        }
        treequeue.enqueue(this.root);


        while (treequeue.isEmpty() == false){

            Node curr = treequeue.dequeue();

            if (curr.left == null){
                curr.left = newnode;
                return;
            }
            else if (curr.left != null){
                treequeue.enqueue(curr.left);
            }

            if (curr.right == null){
                curr.right = newnode;
                return;
            }
            else if (curr.right != null){
                treequeue.enqueue(curr.right);
            }
        }
    }

    /** 
     * Inverts the tree: left and right children of each node are swapped.
     * 
     * For example, the tree:
     * 
     *     1
     *    / \
     *   2   3
     * 
     * is inverted to:
     * 
     *    1
     *   / \
     *  3   2
     * 
     * This inversion is done for all nodes in the tree.
     * 
     */
    public void invert() {
        Queue treequeue = new Queue();
        Node curr = null;
        Node tmp = null;
        treequeue.enqueue(this.root);
        if (this.root == null){
            return;
        }

        while (treequeue.isEmpty() == false){
            curr = treequeue.dequeue();
            tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;

            if (curr.left != null){
                treequeue.enqueue(curr.left);
            }

            if (curr.right != null){
                treequeue.enqueue(curr.right);
            }
        }

       
    }

     public int getHeight() {
        return this.getHeightHelper(this.root, 0);
        
     }

    /** Counts the height of the tree 
     *  Height is defined as the number of edges in the longest path from the root to a leaf node. 
    //  */
     private int getHeightHelper(Node node, int count) {
        if (node == null){
            return count-1;
        }
        
        int left = this.getHeightHelper(node.left, count + 1);
        
        int right = this.getHeightHelper(node.right, count + 1); 

        if (left > right){
            return left;
        }
        else{
            return right;
        }        
     }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        tree.add(11);
        tree.add(12);
        tree.add(13);
        tree.add(14);
        System.out.println(tree.levelOrderTraversal()); // Should print 1 2 3 4 5 6 7
        System.out.println(tree.getHeight());
        tree.invert();
        System.out.println(tree.levelOrderTraversal());


        // tree.invert();

        // System.out.println(tree.levelOrderTraversal()); // Should print 1 3 2 7 6 5 4

        // System.out.println(tree.getHeight()); // Should print 2
    }
}
