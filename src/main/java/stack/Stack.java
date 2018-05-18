package stack;

public interface Stack<T> {
    T getHead();

    void push(T obj);

    T pop();

    boolean isEmpty();
}
