package stack;

import static org.junit.Assert.*;

public class ArrayStackTest extends BaseStackTest{

    @Override
    protected Stack<String> createStack() {
        return new ArrayStack<>();
    }
}