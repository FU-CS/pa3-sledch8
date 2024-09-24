
package pa3;

/**
 * A queue of nodes.
 */
public class Queue {
    Node value;
    Node[] queue;
    int tracker;
    int capacity;

    /** 
     * Constructs an empty queue.
     */
    public Queue() {
        this.tracker = 0;
        this.capacity = 10;
        this.queue = new Node[this.capacity];

        

        
    }

    /**
     * Adds a node to the queue.
     * @param node
     */
    public void enqueue(Node node) {
        if (this.tracker == 0){
            this.queue[0] = node;
            this.tracker = this.tracker + 1;
        }
        
        else if (this.tracker == this.capacity){
            //int total = this.capacity;
            Node[] copylist = new Node[this.capacity * 2];
            for (int i = 0; i < this.capacity; i++){
                copylist[i] = this.queue[i];
            }
            this.queue = copylist;
            this.capacity = this.capacity * 2;
        }

        else{
            this.queue[this.tracker] = node;
            this.tracker = this.tracker + 1;
        }

    }

    /**
     * Removes and returns the node at the front of the queue.
     * @return the node at the front of the queue.
     */
    public Node dequeue() {
        Node dequeued = this.queue[0];
        for (int i = 0; i < this.tracker-1; i++){
            this.queue[i] = this.queue[i+1];
        }
        this.tracker = this.tracker - 1;
        return dequeued;


        
    }

    /**
     * Returns true if the queue is empty.
     * @return true if the queue is empty.
     */
    public boolean isEmpty() {
        if (this.tracker == 0){
            return true;
        }

        else{
            return false;
        }
        
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Node node1 = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        queue.dequeue();
        System.out.println(queue.dequeue().value); // Should print 4
    }
    
}
