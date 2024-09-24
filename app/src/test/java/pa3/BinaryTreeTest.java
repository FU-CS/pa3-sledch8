package pa3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    // Add tests for the BinaryTree class here

    @Test
    public void testLevelOrderTraversal() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        assertEquals("1 2 3 4 5 6 7 ", tree.levelOrderTraversal());
    }

    @Test
    public void testLevelOrderTraversal2() {
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
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 ", tree.levelOrderTraversal());
    }

    @Test
    public void testLevelOrderTraversal3() {
        BinaryTree tree = new BinaryTree();
        assertEquals("", tree.levelOrderTraversal());
    }

    @Test
    public void testinvert() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.invert();
        assertEquals("1 3 2 7 6 5 4 ", tree.levelOrderTraversal());
    }

    @Test
    public void testinvert2() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.invert();
        assertEquals("1 3 2 4 ", tree.levelOrderTraversal());
    }

    @Test
    public void testinvert3() {
        BinaryTree tree = new BinaryTree();
        tree.invert();
        assertEquals("", tree.levelOrderTraversal());
    }

    @Test
    public void testenqueuelength() {
        //Tests to see if the queue grows with the size of the list.
        Queue queue = new Queue();
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(4);
        Node node8 = new Node(3);
        Node node9 = new Node(2);
        Node node10 = new Node(4);
        Node node11 = new Node(3);
        Node node12 = new Node(2);

        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        queue.enqueue(node4);
        queue.enqueue(node5);
        queue.enqueue(node6);
        queue.enqueue(node7);
        queue.enqueue(node8);
        queue.enqueue(node9);
        queue.enqueue(node10);
        queue.enqueue(node11);
        queue.enqueue(node12);
        assertEquals(20, queue.capacity);
    }

    @Test
    public void testgetHeight() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        assertEquals(2, tree.getHeight());
    }

    @Test
    public void testgetHeight2() {
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
        assertEquals(3, tree.getHeight());
    }

    @Test
    public void testgetHeight3() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        assertEquals(0, tree.getHeight());
    }

    @Test
    public void testgetHeight4() {
        BinaryTree tree = new BinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        assertEquals(1, tree.getHeight());
    }


}
