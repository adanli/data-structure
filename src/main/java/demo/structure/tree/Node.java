package demo.structure.tree;

import lombok.Data;

@Data
public class Node<T> {
    private T data;
    private Node<T> parent;
}
