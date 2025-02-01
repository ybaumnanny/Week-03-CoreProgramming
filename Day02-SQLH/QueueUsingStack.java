import java.util.Stack;
class QueueUsingStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    // add
    public void enqueue(int data) {
        s1.push(data);
    }
    // remove
    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty"); // Print message instead of throwing an exception
                return -1; // Return a default value indicating empty queue
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    // peek 
    public int peek() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    // Check if the queue is empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
        System.out.println("Top element: " + queue.peek()); // Output: 20
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 20

        queue.enqueue(40);
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 30
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 40
        
        // Attempting to dequeue from an empty queue
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Queue is empty, -1
        
        // Checking front element of an empty queue
        System.out.println("Top element: " + queue.peek()); // Output: Queue is empty, -1

        System.out.println("Queue empty: " + queue.isEmpty()); // Output: true
    }
}
