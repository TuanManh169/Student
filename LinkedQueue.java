// Node class representing a single node in the queue
class QueueNode {
    int data;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Implementation of FIFO Queue using a linked list
public class LinkedQueue {
    private QueueNode front; // reference to the front of the queue
    private QueueNode rear;  // reference to the rear of the queue
    private int size;        // current size of the queue

    // Constructor to initialize an empty queue
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to add an element to the rear of the queue (enqueue operation)
    public void enqueue(int element) {
        QueueNode newNode = new QueueNode(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    // Method to remove and return the element from the front of the queue (dequeue operation)
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int removedElement = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // if queue becomes empty after dequeue
        }
        size--;
        return removedElement;
    }

    // Method to return the element at the front of the queue without removing it (peek operation)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the current size of the queue
    public int size() {
        return size;
    }
}
