package stack;

import static org.junit.Assert.*;

public class LinkedStackTest extends BaseStackTest {
    @Override
    protected Stack<String> createStack() {
        return new LinkedStack<>();
    }
}