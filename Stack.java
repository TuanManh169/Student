public class Stack {
    private int[] elements;
    private int top; // index of the top element
    private int capacity;

    // Constructor
    public Stack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
        top = -1; // stack is initially empty
    }

    // Push operation
    public void push(int element) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        top++;
        elements[top] = element;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int element = elements[top];
        top--;
        return element;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}
