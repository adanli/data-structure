package demo.structure.tree.binary_clue;

import lombok.Data;

/**
 * 线索二叉树
 */
@Data
public class Tree<T> {
    private Node<T> root;
}
