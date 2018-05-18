package stack;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> head = null;

    @Override
    public T getHead(){
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    @Override
    public void push(T obj){
        head = new Node<>(obj, head);
    }

    @Override
    public T pop(){
        if (head == null) {
            throw new IllegalArgumentException();
        }
        Node<T> oldHead = head;
        head = head.getNext();
        return oldHead.getValue();
    }

    /**  stack.push("123");
        assertEquals("123", stack.getHead());jk
     * Checks rather stack is empty or not
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty(){
        return (head == null);
    }

    private static class Node<U> {
        private final U value;
        private final Node<U> nextNode;

        U getValue(){
            return value;
        }

        Node<U> getNext(){
            return nextNode;
        }

        Node(U value, Node<U> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }
}
