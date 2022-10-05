package demo.structure.tree.binary;

import lombok.Data;

@Data
public class Node<T> {
    private T data;
    private Node<T> lChild;
    private Node<T> rChild;

    public Node(T data) {
        this.data = data;
    }
}
