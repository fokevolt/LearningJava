package tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {
    private Node<T> head = null;

    public void add(T item){
        Node<T> current = new Node<>(item);
        if (isEmpty()) {
            head = current;
        } else {
            head.addNode(current);
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean contains(T item) {
        return !isEmpty() && head.findNode(item);
    }

    public List<T> getElements(){
        List<T> elements = new ArrayList<>();
        head.getNodes(elements);
        return elements;
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

        T getValue() {
            return value;
        }

        void addNode(Node<T> current) {
            switch (current.value.compare(this.value)) {
                case LESS_THEN:
                    if (left != null) {
                        left.addNode(current);
                    } else left = current;
                    break;
                case GREATER_THEN:
                    if (right != null) {
                        right.addNode(current);
                    } else right = current;
                    break;
                default:
                    throw new IllegalArgumentException("The item is already exists");
            }
        }

        boolean findNode(T current) {
            switch (current.compare(this.value)) {
                case LESS_THEN:
                    return left != null && left.findNode(current);
                case GREATER_THEN:
                    return right != null && right.findNode(current);
                default:
                    return true;
            }
        }

        void getNodes(List<T> nodes) {
            if (this.left != null) this.left.getNodes(nodes);
            nodes.add(this.value);
            if (this.right != null) this.right.getNodes(nodes);
        }
    }
}

