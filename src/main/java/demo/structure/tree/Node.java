package demo.structure.tree;

import lombok.Data;

/**
 * 二叉树
 * 链表数据结构
 */
@Data
public class Node<T> {
    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T data) {
        this.data = data;
    }
}
