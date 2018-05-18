package stack;

public class ArrayStack<T> implements Stack<T> {
    private static final int INITIAL_SIZE = 1;
    private int head = -1;
    private Object[] items = new Object[INITIAL_SIZE];

    private void stackEnlarge(){
        final Object[] newStack = new Object[items.length*2];
        for(int i = 0; i < items.length; i++){
            newStack[i] = items[i];
        }
        items = newStack;
    }

    @Override
    public T getHead(){
        if (head < 0) {
            return null;
        }
        return (T) items[head];
    }

    @Override
    public void push(T obj){
        if (head + 1 >= items.length){
            stackEnlarge();
        }
        items[++head] = obj;
    }

    @Override
    public T pop(){
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (T) items[head--];
    }

    @Override
    public boolean isEmpty(){
        return (head < 0);
    }
}
