package demo.structure.tree.binary;

import lombok.Data;

/**
 * 二叉树
 */
@Data
public class Tree<T> {
    private Node<T> node;

    public void setRoot(Node<T> root) {
        this.node = root;
    }

    public Node<T> getRoot() {
        return node;
    }

}
