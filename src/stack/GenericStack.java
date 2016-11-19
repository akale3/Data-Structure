package stack;

/**
 * Created by Aditya on 18-11-2016.
 */
public class GenericStack<T> {
    private int top = -1;
    private T stack[];

    public GenericStack() {
        stack = (T[]) new Object[10];
    }

    public GenericStack(int size) {
        stack = (T[]) new Object[size];
    }

    public void push(T value) {
        if (top < stack.length - 1) {
            stack[++top] = value;
        } else {
            System.out.println("Stack is full. Cannot push more elements.");
        }
    }

    public T pop() {
        if (top > -1) {
            return stack[top--];
        } else {
            System.out.println("Stack is empty. Cannot pop more elements.");
            return null;
        }
    }

    public int size() {
        return top + 1;
    }

    public T peak() {
        if (top > -1) {
            return stack[top];
        }
        return null;
    }

    public boolean isFull() {
        if (top == stack.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (top < 0) {
            return true;
        }
        return false;
    }

}
