package stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Aditya on 18-11-2016.
 */
public class TestStack {

    @Test
    public void test_stack_push_opertion() {
        GenericStack stack = new GenericStack(1);
        stack.push(1);
        Assert.assertEquals("Unexpected peak Value.", 1, stack.peak());
    }

    @Test
    public void test_stack_push_over_stack_limit() {
        GenericStack stack = new GenericStack(1);
        stack.push(1);
        stack.push("one");
    }

    @Test
    public void test_stack_pop_operation() {
        GenericStack stack = new GenericStack(1);
        stack.push(1);
        Assert.assertEquals("Unexpected peak Value.", 1, stack.peak());
        Assert.assertEquals("Unexpected Popped Value.", 1, stack.pop());
        Assert.assertEquals("Unexpected Value.", null, stack.peak());
    }

    @Test
    public void test_stack_pop_from_empty_stack() {
        GenericStack stack = new GenericStack(1);
        Assert.assertEquals("Unexpected peak Value.", null, stack.pop());
    }

    @Test
    public void test_stack_size_operation() {
        GenericStack stack = new GenericStack(2);
        stack.push(1);
        Assert.assertEquals("Unexpected stack size", 1, stack.size());
        stack.push("two");
        Assert.assertEquals("Unexpected stack size", 2, stack.size());
    }

    @Test
    public void test_stack_isFull_operation() {
        GenericStack stack = new GenericStack(2);
        stack.push(1);
        Assert.assertEquals("Unexpected stack size", false, stack.isFull());
        stack.push("two");
        Assert.assertEquals("Unexpected stack size", true, stack.isFull());
    }

    @Test
    public void test_stack_isEmpty_operation() {
        GenericStack stack = new GenericStack(1);
        stack.push(1);
        Assert.assertEquals("Unexpected stack size", false, stack.isEmpty());
        stack.pop();
        Assert.assertEquals("Unexpected stack size", true, stack.isEmpty());
    }

    @Test
    public void test_stack_peak_operation() {
        GenericStack stack = new GenericStack(2);
        stack.push(1);
        Assert.assertEquals("Unexpected value", 1, stack.peak());
        stack.push("two");
        Assert.assertEquals("Unexpected stack size", "two", stack.peak());
    }


}
