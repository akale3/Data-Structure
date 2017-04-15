package queue;

/**
 * Created by Aditya on 2017-04-15.
 */
public class MyQueue {
    private static Node<Integer> top = null;
    private static Node<Integer> rear = null;

    public static void main(String[] args) {
        enQueue(1);
        enQueue(2);
        enQueue(3);
        enQueue(4);
        enQueue(5);
        enQueue(6);
        printQueue();

        System.out.println("Dequeue Element: " + deQueue());
        System.out.println("Dequeue Element: " + deQueue());
        printQueue();

        System.out.println("Removing element 6");
        deleteParticularNode(6);
        printQueue();

        printTopAndRear();
    }

    private static void printTopAndRear() {
        System.out.println("Top of Queue: " + (top != null ? top.toString() : null));
        System.out.println("Rear of Queue: " + (rear != null ? rear.toString() : null));
    }

    private static void enQueue(int data) {
        if (top == null && rear == null) {
            Node<Integer> node = new Node<>(data);
            top = rear = node;
        } else {
            Node<Integer> newNode = new Node<>(data);
            newNode.setPrevious(rear);
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    private static int deQueue() {
        try {
            int data = top.getData();
            if (top == rear) {
                top = rear = null;
            } else {
                top = top.getNext();
                top.setPrevious(null);
            }
            return data;
        } catch (Exception e) {
            System.out.println("Queue is Empty returning negative Max Value");
            return -Integer.MAX_VALUE;
        }
    }

    private static void printQueue() {
        if (top == null) {
            return;
        }
        Node newTop = top;
        while (newTop != null) {
            System.out.print(newTop.getData() + " ");
            newTop = newTop.getNext();
        }
        System.out.println("");
    }

    private static void deleteParticularNode(int data) {
        if (top.getData() == data) {
            top = top.getNext();
            top.setPrevious(null);
            return;
        }
        Node temp = top;
        while ((int) temp.getNext().getData() != data) {
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        if (temp.getNext() == null) {
            rear = temp;
        }
    }

}

class Node<T> {
    private T data;
    private Node<T> previous;
    private Node<T> next;

    public Node() {

    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", previous=" + (null != previous ? previous.getData() : null) +
                ", next=" + (null != next ? next.getData() : null) +
                '}';
    }
}
