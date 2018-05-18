package stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class BaseStackTest {
    private Stack<String> stack;

    protected abstract Stack<String> createStack();

    @Before
    public void setUp() throws Exception {
        stack = createStack();
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_should_throw_if_stack_is_empty() {
        stack.pop();
    }

    @Test
    public void isEmpty() {
        assertTrue(stack.isEmpty());

        stack.push("ss");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void head_returns_null_if_stack_isEmpty() {
        assertNull(stack.getHead());
    }

    @Test
    public void push_changes_header() {
        stack.push("123");
        assertEquals("123", stack.getHead());

        stack.push("1");
        assertEquals("1", stack.getHead());
    }

    @Test
    public void pop_changes_head() {
        stack.push("1");
        stack.push("2");

        stack.pop();
        assertEquals("1", stack.getHead());
        stack.pop();
        assertNull(stack.getHead());
    }

    @Test
    public void push_pop() {
        stack.push("1");
        assertEquals("1", stack.pop());

        stack.push("2");
        stack.push("3");

        assertEquals("3", stack.pop());
        assertEquals("2", stack.pop());
    }
}